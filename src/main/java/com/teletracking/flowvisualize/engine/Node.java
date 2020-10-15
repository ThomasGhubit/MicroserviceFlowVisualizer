package com.teletracking.flowvisualize.engine;

import java.util.Objects;

public class Node {

    private final String name;
    private final Style attributes;

    Node( String name, Style attributes ) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Style getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Node node = ( Node ) o;
        return Objects.equals( name, node.name ) &&
            Objects.equals( attributes, node.attributes );
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, attributes );
    }

}
