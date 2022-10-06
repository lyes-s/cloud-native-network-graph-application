package org.lyess.network_graph_service.hypermedia;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.ws.rs.core.Link;
import java.io.Serializable;
import java.net.URI;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-28 2:02 p.m.
 */
@Schema(name = "LinkResource")
public class LinkResource implements Serializable {

    @Schema(name = "rel", required = true, example = "SELF")
    private String rel;
    @Schema(name = "type", required = true, example = "GET")
    private String type;

    @Schema(name = "uri", required = true, example = "http://localhost:8080/network-graph-service/api/v1/graph/1")
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
