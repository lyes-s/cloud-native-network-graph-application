package org.lyess.network_graph_service.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:45 p.m.
 */
public class Graph {

    private Long id;
    private List<Node> nodes;
    private List<Edge> edges;

    public Long getId() {
        return id;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return id.equals(graph.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
