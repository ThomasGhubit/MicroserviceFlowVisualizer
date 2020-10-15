package com.teletracking.flowvisualize.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
class BitBucketReader {

    private static final Logger log = LoggerFactory.getLogger( BitBucketReader.class );

    private static final String REPO_URL = "https://api.bitbucket.org/2.0/repositories/teleadmin";
    private static final String SDF_FILE_URL_TEMPLATE = REPO_URL + "/%s/src/master/src/main/resources/com.teletracking.yml";

    private final RestTemplate restTemplate;

    BitBucketReader( RestTemplateBuilder restTemplateBuilder, BitBucketAuth bitBucketAuth ) {
        this.restTemplate = bitBucketAuth.addBasicAuth( restTemplateBuilder )
            .build();
    }

    Set<BitBucketRepository> findBitBucketRepositories() {
        log.info( "Searching for projects in BitBucket" );

            // Get bitbucket data or use cached info
        //JsonArray rawRepositories = getAllPages( REPO_URL );
        JsonArray rawRepositories = readTempFile( "cachedForTesting/repoList.json" );

        Set<BitBucketRepository> repositories = new HashSet<>();
        for( JsonElement rawRepositoryElement : rawRepositories ) {
            JsonObject rawRepository = rawRepositoryElement.getAsJsonObject();
            String name = rawRepository.getAsJsonPrimitive( "name" ).getAsString();
            String slug = rawRepository.getAsJsonPrimitive( "slug" ).getAsString();
            log.info( "Found repository {}", name );
            repositories.add( new BitBucketRepository( name, slug ) );
        }
        log.debug( "Done searching for projects in BitBucket, Found: {}", repositories.size() );
        return repositories;
    }

    Optional<String> readSdfDefinition( BitBucketRepository repository ) {
        return readSdfDefinition( repository, 1 );
    }
    private Optional<String> readSdfDefinition( BitBucketRepository repository, int attempt ) {
        String url = String.format( SDF_FILE_URL_TEMPLATE, repository.getSlug() );
        String contents;
        try { contents = restTemplate.getForObject( url, String.class ); }
        catch( HttpClientErrorException e ) {
            if ( "404 NOT FOUND".equals( e.getMessage() ) ) {
                log.debug( "Repository {} does not contain sdf definition", repository );
                return Optional.empty();
            }
            if ( "429 Unknown Status Code".equals( e.getMessage() ) ) {
                log.info( "Attempt {} - {}", attempt, e.getResponseBodyAsString() );
                try { Thread.sleep( 5000 ); }
                catch ( InterruptedException interruptedException ) { interruptedException.printStackTrace(); }
                return readSdfDefinition( repository, attempt + 1 );
            }
            throw e;
        }
        log.debug( "Found SDF file for repository {}", repository.getName() );
        return Optional.ofNullable( contents );
    }

    private JsonArray getAllPages( String url ) {
        JsonArray values = new JsonArray();
        do {
            log.debug( "Reading page " + url );
            String rawResponse = restTemplate.getForObject( url, String.class );
            if ( rawResponse == null ) throw new IllegalStateException( "Could not get values for " + url );
            JsonObject response = JsonParser.parseString( rawResponse ).getAsJsonObject();
            values.addAll( response.getAsJsonArray( "values" ) );
            if ( ! response.has( "next" ) ) break;
            url = response.getAsJsonPrimitive( "next" ).getAsString();
        } while( true );
        return values;
    }

    private JsonArray readTempFile( String file ) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource( "classpath:" + file );
        String raw;
        try ( Reader reader = new InputStreamReader( resource.getInputStream(), UTF_8 ) ) {
            raw = FileCopyUtils.copyToString( reader );
        }
        catch (IOException e) { throw new RuntimeException( "Read Failed" ); }
        return JsonParser.parseString( raw ).getAsJsonArray();
    }

}
