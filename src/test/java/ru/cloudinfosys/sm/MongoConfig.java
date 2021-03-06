package ru.cloudinfosys.sm;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

public class MongoConfig extends AbstractMongoConfiguration {
   @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "spring-mongo";
    }
}
