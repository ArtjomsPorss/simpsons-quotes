package com.artjomporsh.simpsonsquotes.config;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
public class MongoDBConfig {

    @Value("${mongo.url}")
    private String mongoUrl;
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

//    @Bean
//    public MongoTemplate mongoTemplate() throws IOException {
//        EmbeddedMongoFactoryBean mongoFactoryBean = new EmbeddedMongoFactoryBean();
//        mongoFactoryBean.setBindIp(mongoUrl);
//        MongoClient mongoClient = mongoFactoryBean.getObject();
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoDbName);
//        return mongoTemplate;
//    }

}
