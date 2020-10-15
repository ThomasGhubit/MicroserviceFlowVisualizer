package com.teletracking.flowvisualize.middleware;

import com.teletracking.flowvisualize.engine.Edge;
import com.teletracking.flowvisualize.engine.GraphedModel;
import com.teletracking.flowvisualize.engine.Node;

class DisplayInfo {
    public int repulsion = 2600;
    public double friction = 0.5;
    public int stiffness = 512;
    public boolean gravity = true;
}

public class GraphResponse {
    public String  _id = "Viz";
    public String  _rev = "1-e8ceaebda42a2c5a76d6684ff9d867da";
    public DisplayInfo sys = new DisplayInfo();
    public String src = "";
    public String example= "cyoa";
    public String title = "Viz";

    public GraphResponse(String source) {
        this.src = source;
    }

    public GraphResponse(GraphedModel model) {
        StringBuilder src_builder = new StringBuilder();

        for (Edge edge : model.getEdges()) {
            src_builder.append(String.format("%s -> %s\n", edge.getSource(), edge.getDestination()));
        }
        src_builder.append("\n");
        for (Node node : model.getNodes()){
            String attributes = "{";
            for (String attr : node.getAttributes().keySet()) {
                attributes += String.format("%s:%s, ", attr, node.getAttributes().get(attr));
            }
            attributes = attributes.substring(0, attributes.length()-2) + "}";
            src_builder.append(String.format("%s {%s}\n", node.getName(), attributes));
        }

        this.src = src_builder.toString();
    }
}