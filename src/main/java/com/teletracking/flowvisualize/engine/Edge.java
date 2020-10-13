package com.teletracking.flowvisualize.engine;

public class Edge {

    private final String source;
    private final String destination;

    public Edge( String source, String destination ) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

}
