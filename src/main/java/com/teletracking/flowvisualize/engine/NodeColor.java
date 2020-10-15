package com.teletracking.flowvisualize.engine;

public enum NodeColor {

    SERVICE( "#0000ff" ),
    EVENT( "#0FF00" ),
    COMMAND( "#FF0000");

    final String color;

    NodeColor( String color ) {
        this.color = color;
    }

}
