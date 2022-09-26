package org.lyess.network_graph_service.repository;

import org.lyess.network_graph_service.domain.Graph;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:08 p.m.
 */
@ApplicationScoped
public class GraphRepository implements IGraphRepository<Graph, Long> {

    @Override
    public List<Graph> findAll() {
        return null;
    }

    @Override
    public Optional<Graph> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Graph> save(Graph graph) {
        return Optional.empty();
    }
}
