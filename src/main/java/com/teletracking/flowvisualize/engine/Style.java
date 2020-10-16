package com.teletracking.flowvisualize.engine;

import java.util.List;
import java.util.Objects;

public class Style {

    private final String label;
    private final List<String> classes;

    Style( String label, List<String> classes ) {
        this.label = label;
        this.classes = classes;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getClasses() {
        return classes;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Style style = ( Style ) o;
        return Objects.equals( label, style.label ) &&
            Objects.equals( classes, style.classes );
    }

    @Override
    public int hashCode() {
        return Objects.hash( label, classes );
    }

}
