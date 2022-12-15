package com.mongo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableReactiveMongoRepositories
@Slf4j
public class MongoDbExampleApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MongoDbExampleApplication.class, args);
    }

}
