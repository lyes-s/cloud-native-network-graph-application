package org.lyess.network_graph_service.hypermedia;

import javax.ws.rs.core.Link;
import java.io.Serializable;
import java.net.URI;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-28 2:02 p.m.
 */
public class LinkResource implements Serializable {

    private String rel;
    private String type;
    private URI uri;

    public LinkResource(Link link) {
        this.rel = link.getRel();
        this.type = link.getType();
        this.uri = link.getUri();
    }

    public String getRel() {
        return rel;
    }

    public String getType() {
        return type;
    }

    public URI getUri() {
        return uri;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
