package com.teletracking.flowvisualize.engine;

import java.util.Set;

public class GraphedModel {

    private final Set<Node> nodes;
    private final Set<Edge> edges;

    GraphedModel( Set<Node> nodes, Set<Edge> edges ) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

}
