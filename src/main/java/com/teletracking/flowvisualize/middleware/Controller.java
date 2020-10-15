package com.teletracking.flowvisualize.middleware;

import com.teletracking.flowvisualize.engine.Engine;
import com.teletracking.flowvisualize.engine.GraphedModel;
import com.teletracking.flowvisualize.parser.Parser;
import com.teletracking.flowvisualize.parser.ServiceDescription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping
public class Controller {

    private final Engine engine;
    private final Parser parser;

    Controller( Engine engine, Parser parser ) {
        this.engine = engine;
        this.parser = parser;
    }
    
    @GetMapping("/ping")
    public HelloMessage home() {
        return new HelloMessage("Hello, World!");
    }

    @GetMapping("/visualize")
    public GraphedModel visualizeFlow() {
        Set<ServiceDescription> definitions = parser.retrieveDefinitions();

        return engine.buildModel( definitions );
    }
}
