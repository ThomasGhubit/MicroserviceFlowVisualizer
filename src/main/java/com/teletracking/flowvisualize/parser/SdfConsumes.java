package com.teletracking.flowvisualize.parser;

import java.util.Map;

public class SdfConsumes {

    private Map<String, SdfEvent> events;
    private Map<String, SdfCommand> commands;

    public Map<String, SdfEvent> getEvents() {
        return events;
    }

    public void setEvents( Map<String, SdfEvent> events ) {
        this.events = events;
    }

    public Map<String, SdfCommand> getCommands() {
        return commands;
    }

    public void setCommands( Map<String, SdfCommand> commands ) {
        this.commands = commands;
    }

}
