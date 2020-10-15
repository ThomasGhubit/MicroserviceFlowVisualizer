package com.teletracking.flowvisualize.engine;

import com.teletracking.flowvisualize.parser.SdfCommand;
import com.teletracking.flowvisualize.parser.SdfEvent;
import com.teletracking.flowvisualize.parser.ServiceDescription;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
class EngineImpl implements Engine {

    @Override
    public GraphedModel buildModel( Set<ServiceDescription> definitions ) {
        Set<Node> nodes = definitions.stream()
            .flatMap( this::buildNodes )
            .collect( Collectors.toSet() );

        Set<Edge> edges = definitions.stream()
            .flatMap( this::buildEdges )
            .collect( Collectors.toSet() );

        return new GraphedModel( nodes, edges );
    }

    private Stream<Node> buildNodes( ServiceDescription service ) {
        return Stream.of(
                Stream.of( buildServiceNode( service ) ),
                buildEventNodes( service ),
                buildCommandNodes( service )
            )
            .reduce( Stream::concat )
            .orElse( Stream.empty() );
    }

    private Node buildServiceNode( ServiceDescription service ) {
        return buildNode( service.getId(), service.getName(), NodeColor.SERVICE );
    }

    private Stream<Node> buildEventNodes( ServiceDescription service ) {
        return service.getDefinition().getAllEvents().stream()
            .map( SdfEvent::getName )
            .map( eventName -> buildNode( eventName, NodeColor.EVENT ) );
    }

    private Stream<Node> buildCommandNodes( ServiceDescription service ) {
        return service.getDefinition().getAllCommands().stream()
            .map( SdfCommand::getName )
            .map( commandName -> buildNode( commandName, NodeColor.COMMAND ) );
    }

    private Node buildNode( String name, NodeColor color ) {
        return buildNode( name, name, color );
    }

    private Node buildNode( String id, String name, NodeColor color ) {
        return new Node(
            id,
            new Style(
                name,
                color.color
            )
        );
    }

    private Stream<Edge> buildEdges( ServiceDescription service ) {
        return Stream.concat(
            buildInputEdges( service ),
            buildOutputEdges( service )
        );
    }

    private Stream<Edge> buildInputEdges( ServiceDescription service ) {
        return Stream.concat(
                service.getDefinition().getConsumedEvents().stream().map( SdfEvent::getName ),
                service.getDefinition().getConsumedCommands().stream().map( SdfCommand::getName )
            )
            .map( name -> new Edge( name, service.getId() ) );
    }

    private Stream<Edge> buildOutputEdges( ServiceDescription service ) {
        return Stream.concat(
            service.getDefinition().getProducedEvents().stream().map( SdfEvent::getName ),
            service.getDefinition().getProducedCommands().stream().map( SdfCommand::getName )
        )
            .map( name -> new Edge( service.getId(), name ) );
    }

}
