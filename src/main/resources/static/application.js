( function( $ ) {

    $( document ).ready( function () {

        $.getJSON( '/visualize', function( data ) {

            var el = data.nodes.map( function( node ) {
                return {
                    data: {
                        id: node.name,
                        label: node.attributes.label
                    },
                    classes: node.attributes.classes.concat( 'nohighlight' )
                }
            }).concat(
                data.edges.map( function( edge ) {
                    return {
                        data: {
                            id: edge.source + '-' + edge.destination,
                            source: edge.source,
                            target: edge.destination
                        },
                        classes: [ 'nohighlight' ]
                    }
                })
            );

            //console.log( el );

            var cy = cytoscape({
                container: $('#cy'),
                elements: el,

                style: [ {
                    selector: 'node.service.nohighlight',
                    style: { 'background-color': '#009' }
                }, {
                    selector: 'node.event.nohighlight',
                    style: { 'background-color': '#060' }
                }, {
                    selector: 'node.command.nohighlight',
                    style: { 'background-color': '#600' }
                }, {
                    selector: 'node.service.highlight',
                    style: { 'background-color': '#00f' }
                }, {
                    selector: 'node.event.highlight',
                    style: { 'background-color': '#0f0' }
                }, {
                    selector: 'node.command.highlight',
                    style: { 'background-color': '#f00' }
                }, {
                    selector: 'node',
                    style: { 'label': 'data(label)' }
                }, {
                    selector: 'node.nohighlight',
                    style: {
                        'opacity': 0.25,
                        'z-index': 0
                    }
                }, {
                    selector: 'node.highlight',
                    style: {
                        'opacity': 1,
                        'z-index': 100
                    }
                }, {
                    selector: 'edge',
                    style: {
                        'width': 3,
                        'target-arrow-shape': 'triangle',
                        'curve-style': 'bezier'
                    }
                }, {
                    selector: 'edge.nohighlight',
                    style: {
                        'line-color': '#ccc',
                        'target-arrow-color': '#ccc',
                        'z-index': 0
                    }
                }, {
                    selector: 'edge.highlight',
                    style: {
                        'line-color': '#999',
                        'target-arrow-color': '#999',
                        'z-index': 100
                    }
                }],

                // layout: {
                //     name: 'concentric'
                // }
                // layout: {
                //     directed: true,
                //     nodeDimensionsIncludeLabels: true,
                //     //spacingFactor: 10,
                //     name: 'breadthfirst'
                // }
                layout: {
                    //directed: true,
                    nodeDimensionsIncludeLabels: true,
                    componentSpacing: 1200,
                    nodeOverlap: 16,
                    nestingFactor: 10,
                    animate: true,
                    name: 'cose'
                }
            });

            cy.on( 'select', 'node', function( event ) {
                event.cy.$( ':unselected' )
                    .addClass( 'nohighlight' )
                    .removeClass( 'highlight' );
                event.cy.$( ':selected' )
                    .addClass( 'highlight' )
                    .removeClass( 'nohighlight' );
                event.target.neighborhood()
                    .addClass( 'highlight' )
                    .removeClass( 'nohighlight' );
            });

        });

    });
}( jQuery ));
