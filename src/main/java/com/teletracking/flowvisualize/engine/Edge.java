package com.teletracking.flowvisualize.engine;

import java.util.Objects;

public class Edge {

    private final String source;
    private final String destination;

    Edge( String source, String destination ) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Edge edge = ( Edge ) o;
        return Objects.equals( source, edge.source ) &&
            Objects.equals( destination, edge.destination );
    }

    @Override
    public int hashCode() {
        return Objects.hash( source, destination );
    }

}
