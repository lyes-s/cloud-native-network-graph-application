package org.lyess.network_graph_service.domain;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.lyess.network_graph_service.hypermedia.Hypermedia;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:45 p.m.
 */
@Schema(name = "Graph")
@JsonbPropertyOrder({"id", "nodes", "edges", "links"})
public class Graph extends Hypermedia implements Serializable {
    @NotBlank(message = "must not be empty or null")
    @Size(min = 1, max = 100, message = "Id Size is Between 1 - 100 Digits")
    @Schema(name = "id", required = true, example = "1")
    private String id;

    @Schema(implementation = Node.class)
    private Set<Node> nodes;

    @Schema(implementation = Edge.class)
    private Set<Edge> edges;

    public String getId() {
        return id;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
    public void setId(String id) {
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
        if (!(o instanceof Graph)) return false;
        Graph graph = (Graph) o;
        return getId().equals(graph.getId()) && getNodes().equals(graph.getNodes()) && getEdges().equals(graph.getEdges());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNodes(), getEdges());
    }
}
