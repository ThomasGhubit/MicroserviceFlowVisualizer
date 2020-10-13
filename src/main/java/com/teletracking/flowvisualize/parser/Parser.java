package com.teletracking.flowvisualize.parser;

import java.io.IOException;
import java.util.Set;

public interface Parser {

    Set<SdfDefinition> retrieveDefinitions() throws IOException;

}
