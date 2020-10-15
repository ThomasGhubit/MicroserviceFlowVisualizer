package com.teletracking.flowvisualize.engine;

import com.teletracking.flowvisualize.parser.SdfDefinition;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class EngineImpl implements Engine {

    @Override
    public GraphedModel buildModel( Set<SdfDefinition> definition ) {
        return null;
    }

}
