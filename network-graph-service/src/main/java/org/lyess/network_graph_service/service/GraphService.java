package org.lyess.network_graph_service.service;

import org.lyess.network_graph_service.domain.Graph;
import org.lyess.network_graph_service.repository.IGraphRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:22 p.m.
 */
@ApplicationScoped
public class GraphService implements IGraphService<Graph, String> {

    @Inject
    private IGraphRepository<Graph, String> graphRepository;

    @Override
    public List<Graph> getAll() {
        return graphRepository.findAll();
    }

    @Override
    public Optional<Graph> findGraphById(String id) {
        return Optional.empty();
    }
}
