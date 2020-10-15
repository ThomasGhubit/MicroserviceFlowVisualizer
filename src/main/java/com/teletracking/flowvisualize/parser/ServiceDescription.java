package com.teletracking.flowvisualize.parser;

public class ServiceDescription {

    private final String id;
    private final String name;
    private final SdfDefinition definition;

    ServiceDescription( BitBucketRepository repository, SdfDefinition definition ) {
        this.id = repository.getSlug();
        this.name = repository.getName();
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SdfDefinition getDefinition() {
        return definition;
    }

}
