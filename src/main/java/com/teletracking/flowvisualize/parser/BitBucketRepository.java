package com.teletracking.flowvisualize.parser;

class BitBucketRepository {

    private final String name;
    private final String slug;

    BitBucketRepository( String name, String slug ) {
        this.name = name;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    @Override
    public String toString() {
        return name;
    }

}
