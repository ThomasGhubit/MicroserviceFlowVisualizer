package com.teletracking.flowvisualize.engine;

import java.util.List;

public class GraphedModel {

    private final List<Node> nodes;
    private final List<Edge> edges;

    public GraphedModel( List<Node> nodes, List<Edge> edges ) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

}
