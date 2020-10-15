package com.teletracking.flowvisualize.parser;

import java.util.Map;

public class SdfEvent {

    private String name;
    private String schemaUri;
    private Map<String, SdfCommand> commands;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSchemaUri() {
        return schemaUri;
    }

    public void setSchemaUri( String schemaUri ) {
        this.schemaUri = schemaUri;
    }

    public Map<String, SdfCommand> getCommands() {
        return commands;
    }

    public void setCommands( Map<String, SdfCommand> commands ) {
        this.commands = commands;
    }

}
