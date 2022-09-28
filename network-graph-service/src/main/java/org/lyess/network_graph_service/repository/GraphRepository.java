package org.lyess.network_graph_service.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.lyess.network_graph_service.domain.Graph;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:08 p.m.
 */
@ApplicationScoped
public class GraphRepository implements IGraphRepository<Graph, String> {

    @Inject
    private MongoDatabase database;

    @Inject
    @ConfigProperty(name = "mongo.client.database.collection")
    private String collectionName;

    @Override
    public List<Graph> findAll() {
        MongoCollection<Graph> collection = database.getCollection(collectionName, Graph.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Optional<Graph> findById(String id) {
        return Optional.empty();
    }
}
