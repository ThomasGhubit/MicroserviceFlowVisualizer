package com.teletracking.flowvisualize.parser;

public class SdfDefinition {

    private String name;
    private String type;
    private String version;

    private SdfConsumes consumes;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version ) {
        this.version = version;
    }

    public SdfConsumes getConsumes() {
        return consumes;
    }

    public void setConsumes( SdfConsumes consumes ) {
        this.consumes = consumes;
    }

}
