package com.teletracking.flowvisualize.parser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource( "classpath:bitbucket/bitbucketAuth.properties" )
class BitBucketConfiguration {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    BitBucketAuth defineBitBucketAuth() {
        return new BitBucketAuth( username, password );
    }

}
