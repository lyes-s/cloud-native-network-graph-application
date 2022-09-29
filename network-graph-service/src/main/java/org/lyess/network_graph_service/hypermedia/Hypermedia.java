package org.lyess.network_graph_service.hypermedia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-28 2:01 p.m.
 */
public class Hypermedia implements Serializable {

    private List<LinkResource> links = new ArrayList<>();

    public void addLink(LinkResource link) {
        links.add(link);
    }

    public List<LinkResource> getLinks() {
        return links;
    }

    public void setLinks(List<LinkResource> links) {
        this.links = links;
    }
}
