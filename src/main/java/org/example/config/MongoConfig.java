package org.example.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.example.config.properties.MongoClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableConfigurationProperties(MongoClientProperties.class)
@EnableMongoRepositories(basePackages = "org.example.repository")
public class MongoConfig {

    @Bean
    public MongoClient customMongoClient(MongoClientProperties mongoClientProperties) {
        //mongodb://root:pw@localhost:27017/?authSource=admin
        //mongodb://root:example@localhost:27017/language_courses?authSource=admin
        String connectUri = String.format("mongodb://%1$s:%2$s@%3$s:%4$d/%5$s?authSource=%6$s",
                mongoClientProperties.getUsername(),
                mongoClientProperties.getPassword(),
                mongoClientProperties.getHost(),
                mongoClientProperties.getPort(),
                mongoClientProperties.getDatabase(),
                mongoClientProperties.getAuthenticationDatabase());
        MongoClient client = MongoClients.create(connectUri);
        return client;
    }

//    @Bean
//    public MongoDatabaseFactory customMongoDbFactory(MongoClient customMongoClient) {
//        return new SimpleMongoClientDatabaseFactory(customMongoClient, "web");
//    }

/*    @Bean
    public MongoTemplate customMongoTemplate(MongoClient customMoongoClient, MongoClientProperties mongoClientProperties) {
        return new MongoTemplate(customMoongoClient, mongoClientProperties.getDatabase());
    }*/
}