package org.lyess.network_graph_service.domain;

import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:54 p.m.
 */
public class Edge {

    private Long id;
    private Node source;
    private Node destination;
    private Long cost;

    public Long getId() {
        return id;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public Long getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return id.equals(edge.id) && ( (source.equals(edge.source) && destination.equals(edge.destination))
                || (source.equals(edge.destination) && destination.equals(edge.source)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, destination, cost);
    }
}
