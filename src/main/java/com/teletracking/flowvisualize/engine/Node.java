package com.teletracking.flowvisualize.engine;

import java.util.Map;

public class Node {

    private final String name;
    private final Map<String, ?> attributes;

    public Node( String name, Map<String, ?> attributes ) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, ?> getAttributes() {
        return attributes;
    }

}
