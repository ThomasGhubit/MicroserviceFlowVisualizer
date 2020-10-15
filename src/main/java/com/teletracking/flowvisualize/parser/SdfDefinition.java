package com.teletracking.flowvisualize.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<SdfEvent> getConsumedEvents() {
        return new HashSet<>( consumes.getEvents().values() );
    }

    public Set<SdfCommand> getConsumedCommands() {
        return new HashSet<>( consumes.getCommands().values() );
    }

    public Set<SdfEvent> getProducedEvents() {
        return consumes.getCommands().values().stream()
            .flatMap( command -> command.getProducedEvents().stream() )
            .collect( Collectors.toSet() );
    }

    public Set<SdfCommand> getProducedCommands() {
        return consumes.getEvents().values().stream()
            .flatMap( event -> event.getProducedCommands().stream() )
            .collect( Collectors.toSet() );
    }

    public Set<SdfEvent> getAllEvents() {
        HashSet<SdfEvent> allEvents = new HashSet<>();
        allEvents.addAll( getConsumedEvents() );
        allEvents.addAll( getProducedEvents() );
        return allEvents;
    }

    public Set<SdfCommand> getAllCommands() {
        HashSet<SdfCommand> allCommands = new HashSet<>();
        allCommands.addAll( getConsumedCommands() );
        allCommands.addAll( getProducedCommands() );
        return allCommands;
    }

}
