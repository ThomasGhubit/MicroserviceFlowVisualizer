package com.teletracking.flowvisualize.engine;

import com.teletracking.flowvisualize.parser.SdfDefinition;

public interface Engine {

    GraphedModel buildModel( SdfDefinition definition );

}
