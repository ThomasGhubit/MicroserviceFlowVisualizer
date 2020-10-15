package com.teletracking.flowvisualize.engine;

import com.teletracking.flowvisualize.parser.ServiceDescription;

import java.util.Set;

public interface Engine {

    GraphedModel buildModel( Set<ServiceDescription> definitions );

}
