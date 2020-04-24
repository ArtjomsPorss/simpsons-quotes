package com.artjomporsh.simpsonsquotes.config;

import com.artjomporsh.simpsonsquotes.character.SimpsonsCharacter;
import com.artjomporsh.simpsonsquotes.quotes.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.init.AbstractRepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import java.io.IOException;

@Configuration
public class MongoDBConfig {

    private Logger LOG = LoggerFactory.getLogger(MongoDBConfig.class);

    private String mongoUrl="localhost";
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

    @Value("classpath:db/characters.json")
    private Resource charactersJson;
    @Value("classpath:db/phrases.json")
    private Resource prasesJson;

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        EmbeddedMongoFactoryBean mongoFactoryBean = new EmbeddedMongoFactoryBean();
        mongoFactoryBean.setBindIp(mongoUrl);
        MongoClient mongoClient = mongoFactoryBean.getObject();
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoDbName);
        LOG.info("MongoTemplate created: ", mongoTemplate.toString());

        return mongoTemplate;
    }

    @Bean
    public AbstractRepositoryPopulatorFactoryBean repositoryPopulator(ObjectMapper objectMapper, MongoTemplate template) throws IOException {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        template.remove(SimpsonsCharacter.class);
        template.remove(Quote.class);
        factory.setMapper(objectMapper);
        factory.setResources(new Resource[]{charactersJson, prasesJson});
        return factory;
    }

}
