package com.teletracking.flowvisualize.middleware;

import com.teletracking.flowvisualize.engine.GraphedModel;

class GraphResponse {

    private GraphResponse() {}

    static String buildTextOutput( GraphedModel model ) {
        StringBuilder sb = new StringBuilder();

        model.getEdges().forEach( edge ->
            sb.append( edge.getSource() )
                .append( " -> ")
                .append( edge.getDestination() )
                .append( '\n' )
        );
        sb.append( '\n' );

        model.getNodes().forEach( node ->
            sb.append( node.getName() )
                .append( " {color:" )
                .append( node.getAttributes().getColor() )
                .append( ", label:" )
                .append( node.getAttributes().getLabel() )
                .append( "}\n" )
        );

        return sb.toString();
    }

}