package com.teletracking.flowvisualize.engine;

import com.teletracking.flowvisualize.parser.SdfDefinition;

import java.util.Set;

public interface Engine {

    GraphedModel buildModel( Set<SdfDefinition> definition );

}
