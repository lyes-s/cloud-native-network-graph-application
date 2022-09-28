package org.lyess.network_graph_service.producer;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 7:33 p.m.
 */
public class MongoProducer {

    private MongoClient mongoClient;

    private MongoCredential credential;

    private CodecRegistry pojoCodecRegistry;

    @Inject
    @ConfigProperty(name = "mongo.client.host")
    private String mongodbHost;

    @Inject
    @ConfigProperty(name = "mongo.client.port")
    private int mongodbPort;

    @Inject
    @ConfigProperty(name = "mongo.client.database.username")
    private String username;

    @Inject
    @ConfigProperty(name = "mongo.client.database.password")
    private String password;

    @Inject
    @ConfigProperty(name = "mongo.client.database.name")
    private String mongoDatabaseName;

    @PostConstruct
    void initialize() {
        credential = MongoCredential.createCredential(username, mongoDatabaseName, password.toCharArray());
        mongoClient = new MongoClient(new ServerAddress(mongodbHost, mongodbPort), credential, MongoClientOptions.builder().build());
        pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

    @Produces
    @ApplicationScoped
    public MongoClient client() {
        return mongoClient;
    }

    @Produces
    @ApplicationScoped
    public MongoDatabase database() {
        return mongoClient.getDatabase(mongoDatabaseName).withCodecRegistry(pojoCodecRegistry);
    }


}
