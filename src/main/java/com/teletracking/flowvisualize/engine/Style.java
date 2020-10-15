package com.teletracking.flowvisualize.engine;

import java.util.Objects;

public class Style {

    private final String color;
    private final String label;

    Style( String label, String color ) {
        this.color = color;
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Style style = ( Style ) o;
        return Objects.equals( color, style.color ) &&
            Objects.equals( label, style.label );
    }

    @Override
    public int hashCode() {
        return Objects.hash( color, label );
    }

}
