package org.lyess.network_graph_service.repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:04 p.m.
 */
public interface IGraphRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
}
