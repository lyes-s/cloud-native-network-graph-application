package org.lyess.network_graph_service.repository;

import org.lyess.network_graph_service.domain.Graph;

import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:04 p.m.
 */
public interface IGraphRepository {

    List<Graph> findAll();
    Optional<Graph> findById(String id);
    Optional<Graph> save(Graph graph);

}
