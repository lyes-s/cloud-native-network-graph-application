package org.lyess.network_graph_service.domain;

import java.net.Inet4Address;
import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:45 p.m.
 */
public class Node {
    private Long id;
    private Inet4Address inet4Address;

    public Long getId() {
        return id;
    }

    public Inet4Address getInet4Address() {
        return inet4Address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id) && inet4Address.equals(node.inet4Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inet4Address);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", inet4Address=" + inet4Address +
                '}';
    }
}
