package com.teletracking.flowvisualize.middleware;

import com.teletracking.flowvisualize.engine.Engine;
import com.teletracking.flowvisualize.engine.GraphedModel;
import com.teletracking.flowvisualize.parser.Parser;
import com.teletracking.flowvisualize.parser.SdfDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class Controller {

    private Engine engine;

    private Parser parser;
    
    @GetMapping("/ping")
    public HelloMessage home() {
        return new HelloMessage("Hello, World!");
    }

    @GetMapping("/visualize")
    public Set<GraphedModel> visualizeFlow() {
        Set<SdfDefinition> definitions = new HashSet<>();
        try {
            definitions = parser.retrieveDefinitions();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return definitions.stream().map(definition -> engine.buildModel(definition)).collect(Collectors.toSet());
    }
}
