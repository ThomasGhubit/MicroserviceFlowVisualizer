package com.teletracking.flowvisualize.middleware;

import com.teletracking.flowvisualize.engine.Engine;
import com.teletracking.flowvisualize.engine.GraphedModel;
import com.teletracking.flowvisualize.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@RestController
@RequestMapping
public class Controller {

    @Service
    public class RestService {
        private final RestTemplate restTemplate;

        public RestService(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.build();
        }

        public String getPostsPlainJSON(String url) {
            return this.restTemplate.getForObject(url, String.class);
        }
    }



    @Autowired
    private Engine engine;

    @Autowired
    private Parser parser;
    
    @GetMapping("/ping")
    public HelloMessage home() {
        return new HelloMessage("Hello, World!");
    }

    @GetMapping("/visualize")
    public GraphedModel visualizeFlow() {
        //String url = "https://bitbucket.org/teleadmin/" + repositoryName + "/src/master/src/main/resources/com.teletracking.yml";
        //String data = new Controller().new RestService(null).getPostsPlainJSON(url);
        // engine.buildModel(parser.parseData(data));
        return engine.buildModel();
    }
}
