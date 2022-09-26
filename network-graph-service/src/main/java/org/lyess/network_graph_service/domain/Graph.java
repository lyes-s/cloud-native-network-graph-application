package org.lyess.network_graph_service.domain;

import java.util.Objects;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:45 p.m.
 */
public class Graph {

    private Long id;
    private Set<Node> nodes;
    private Set<Edge> edges;

    public Long getId() {
        return id;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
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
