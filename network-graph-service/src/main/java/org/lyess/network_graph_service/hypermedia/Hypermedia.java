package org.lyess.network_graph_service.hypermedia;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-28 2:01 p.m.
 */
@Schema(name = "Hypermedia")
public class Hypermedia implements Serializable {

    @Schema(name = "links", required = true)
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
