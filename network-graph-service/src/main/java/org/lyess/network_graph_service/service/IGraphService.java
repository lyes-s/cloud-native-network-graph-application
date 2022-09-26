package org.lyess.network_graph_service.service;

import org.lyess.network_graph_service.domain.Graph;
import org.lyess.network_graph_service.exception.GraphAlreadyExistsException;

import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:21 p.m.
 */
public interface IGraphService<T, ID> {

    List<T> getAll();

    Optional<T> findGraphById(ID id);

    Optional<T> save(T t);

}
