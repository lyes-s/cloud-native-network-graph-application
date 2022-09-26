package org.lyess.network_graph_service.domain;

import java.util.Objects;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 12:45 p.m.
 */
public class Node {

    private String ip4Address;

    public String getIp4Address() {
        return ip4Address;
    }

    public void setIp4Address(String ip4Address) {
        this.ip4Address = ip4Address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return ip4Address.equals(node.ip4Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip4Address);
    }

    @Override
    public String toString() {
        return "Node{ ip4Address=" + ip4Address + "}";
    }
}
