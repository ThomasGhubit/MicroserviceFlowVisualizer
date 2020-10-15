package com.teletracking.flowvisualize.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
class ParserImpl implements Parser {

    private static final Logger log = LoggerFactory.getLogger( ParserImpl.class );

    private static final ObjectMapper mapper = new ObjectMapper( new YAMLFactory() );

    private final BitBucketReader bitBucketReader;

    ParserImpl( BitBucketReader reader ) {
        this.bitBucketReader = reader;
    }

    @Override
    public Set<ServiceDescription> retrieveDefinitions() {
        return bitBucketReader.findBitBucketRepositories()
            .stream()
            .flatMap( this::convertToServiceDescription )
            .collect( Collectors.toSet() );
    }

    private Stream<ServiceDescription> convertToServiceDescription( BitBucketRepository repository ) {
        return readCachedSdfFile( repository )
                // Connect to bitbucket for sdf definition
//            .or( () -> bitBucketReader.readSdfDefinition( repository ) )
            .flatMap( contents -> readYaml( repository, contents ) )
            .map( sdfDefinition -> new ServiceDescription( repository, sdfDefinition ) )
            .stream();
    }

    private Optional<SdfDefinition> readYaml( BitBucketRepository repository, String sdfContents ) {
        try {
            return Optional.of( mapper.readValue( sdfContents, SdfDefinition.class ) );
        }
        catch ( JsonProcessingException e ) {
            log.error( "Could not parse SDF Definition for " + repository, e );
            return Optional.empty();
        }
    }

    private Optional<String> readCachedSdfFile( BitBucketRepository repository ) {
        if ( ! doesSdfFileExist( repository ) ) return Optional.empty();
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource( "classpath:cachedForTesting/sdf/" + repository.getSlug() + ".yaml" );
        try ( Reader reader = new InputStreamReader( resource.getInputStream(), UTF_8 ) ) {
            return Optional.of( FileCopyUtils.copyToString( reader ) );
        }
        catch ( IOException e ) {
            log.error( "Could not read cached sdf file for " + repository, e );
            return Optional.empty();
        }
    }

    private boolean doesSdfFileExist( BitBucketRepository repository ) {
        if ( ! CachedSdfHelper.isCached( repository ) ) return false;
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource( "classpath:cachedForTesting/sdf/" + repository.getSlug() + ".yaml" );
        return resource.exists();
    }

    //    private void cacheSdfFile( BitBucketRepository repository ) {
//        if ( doesSdfFileExist( repository ) ) return;
//        new File( "/sdf" ).mkdir();
//        bitBucketReader.readSdfDefinition( repository )
//            .ifPresent( contents -> {
//                try {
//                    String filePath = "/sdf/" + repository.getSlug() + ".yaml";
//                    log.debug( "Writing file {}", filePath );
//                    Files.write( Path.of( filePath ), contents.getBytes() );
//                } catch ( IOException e ) {
//                    e.printStackTrace();
//                }
//            } );
//    }

}
