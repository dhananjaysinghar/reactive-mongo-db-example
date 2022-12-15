package com.mongo;

import com.mongo.model.BookingRequest;
import com.mongo.repo.BookingRepository;
import com.mongo.utils.EmbeddedMongoDBUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
class MongoDbExampleApplicationTests {

    @Autowired
    private BookingRepository bookingRepository;


    @BeforeEach
    public void setUp() {
        EmbeddedMongoDBUtils.startMongoDb("localhost", 18050);
    }

    @AfterEach
    public void tearDown() {
        EmbeddedMongoDBUtils.stopMongoDb();
    }

    @Test
    void contextLoads() {
        String id = UUID.randomUUID().toString();
        StepVerifier.create(bookingRepository.save(BookingRequest.builder().bookingId(id).build()))
                .expectSubscription()
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();

        StepVerifier.create(bookingRepository.findById(id))
                .expectSubscription()
                .assertNext(e -> Assertions.assertEquals(e.getBookingId(), id))
                .verifyComplete();
    }
}
