package com.teletracking.flowvisualize.parser;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class SdfConsumes {

    private Map<String, SdfEvent> events;
    private Map<String, SdfCommand> commands;

    public Map<String, SdfEvent> getEvents() {
        return Optional.ofNullable( events )
            .orElse( Collections.emptyMap() );
    }

    public void setEvents( Map<String, SdfEvent> events ) {
        this.events = events;
    }

    public Map<String, SdfCommand> getCommands() {
        return Optional.ofNullable( commands )
            .orElse( Collections.emptyMap() );
    }

    public void setCommands( Map<String, SdfCommand> commands ) {
        this.commands = commands;
    }

}
