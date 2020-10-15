package com.teletracking.flowvisualize.middleware;

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
    public String src;
    public String example= "cyoa";
    public String title = "Viz";

    public GraphResponse(String source) {
        this.src = source;
    }
}