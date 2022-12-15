//package com.mongo.config;
//
//import com.mongodb.*;
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//
//@Configuration
//(exclude = {MongoReactiveAutoConfiguration.class, MongoAutoConfiguration.class, MongoReactiveRepositoriesAutoConfiguration.class})
//public class AppMongoConfig {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//
//    @Bean
//    public MongoClient mongoTemplate() {
//        MongoProperties mongoProperties = applicationContext.getBean(MongoProperties.class);
//        return MongoClients.create(createMongoClientSettings(mongoProperties));
//    }
//
//    private MongoClientSettings createMongoClientSettings(MongoProperties mongoProperties) {
//        return MongoClientSettings.builder()
//                .readConcern(ReadConcern.DEFAULT)
//                .writeConcern(WriteConcern.MAJORITY)
//                .readPreference(ReadPreference.primary())
//                .applyConnectionString(new ConnectionString(mongoProperties.getUri()))
//                .build();
//    }
//
//    @PostConstruct
//    public void init() {
//        MappingMongoConverter mappingMongoConverter = applicationContext.getBean(MappingMongoConverter.class);
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//    }
//
//
//}
