package com.teletracking.flowvisualize.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SdfCommand {

    private String name;
    private String schemaUri;
    private List<String> roles;
    private String viewModelSchemaUri;
    private List<String> index;
    private SdfEvent domainEvent;
    private Map<String, SdfEvent> events;

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles( List<String> roles ) {
        this.roles = roles;
    }

    public String getViewModelSchemaUri() {
        return viewModelSchemaUri;
    }

    public void setViewModelSchemaUri( String viewModelSchemaUri ) {
        this.viewModelSchemaUri = viewModelSchemaUri;
    }

    public List<String> getIndex() {
        return index;
    }

    public void setIndex( List<String> index ) {
        this.index = index;
    }

    public SdfEvent getDomainEvent() {
        return domainEvent;
    }

    public void setDomainEvent( SdfEvent domainEvent ) {
        this.domainEvent = domainEvent;
    }

    public Map<String, SdfEvent> getEvents() {
        return events;
    }

    public void setEvents( Map<String, SdfEvent> events ) {
        this.events = events;
    }

    public Set<SdfEvent> getProducedEvents() {
        return new HashSet<>( events.values() );
    }

}
