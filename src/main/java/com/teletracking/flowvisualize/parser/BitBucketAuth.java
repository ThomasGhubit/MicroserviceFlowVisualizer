package com.teletracking.flowvisualize.parser;

import org.springframework.boot.web.client.RestTemplateBuilder;

class BitBucketAuth {

    private final String username;
    private final String password;

    BitBucketAuth( String username, String password ) {
        this.username = username;
        this.password = password;
    }

    RestTemplateBuilder addBasicAuth( RestTemplateBuilder templateBuilder ) {
        return templateBuilder.basicAuthorization( username, password );
    }

}
