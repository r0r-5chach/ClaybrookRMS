package com.mawkish.claybrookrms.tools;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;


public class DBHandler {
    private MongoDatabase database;

    public DBHandler() {
        init();
    }

    private void init() {
        String uri = "mongodb://localhost:27017/";
        MongoClient client = MongoClients.create(uri);
        database = client.getDatabase("ClaybrookZoo");
    }


    public MongoCollection<Document> getCollection(String name) {
        return database.getCollection(name);
    }


    public FindIterable<Document> getUser(String username) {
        MongoCollection<Document> collection = database.getCollection("Users");
            return collection.find(Filters.eq("_username", username));
    }
}
