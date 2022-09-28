package org.lyess.network_graph_service.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:54 p.m.
 */
public class Edge {
    @NotBlank(message = "must not be empty or null")
    private Node source;
    @NotBlank(message = "must not be empty or null")
    private Node destination;
    @NotBlank(message = "must not be empty or null")
    @Size(min = 1, max = 100, message = "Cost Size is Between 1 - 100 Digits")
    private int cost;

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return ( (source.equals(edge.source) && destination.equals(edge.destination))
                || (source.equals(edge.destination) && destination.equals(edge.source)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, cost);
    }
}
