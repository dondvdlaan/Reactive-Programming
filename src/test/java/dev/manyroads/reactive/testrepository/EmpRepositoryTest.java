package dev.manyroads.reactive.testrepository;

import dev.manyroads.reactive.repository.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

/**
 * Testing of EmpRepository
 */
@SpringBootTest
public class EmpRepositoryTest {

    @Autowired
    EmpRepository repo;

    /**
     * Test total records in database by counting and comparing to expectation
     */
    @Test
    void checkCount_direct() {
        StepVerifier
                // When
                .create(repo.count())

                // Then
                .expectNext(5L)
                .verifyComplete();
    }

    /**
     * Test total records in database by findAll() and comparing to expectation
     */
    @Test
    void checkCount_list() {
        StepVerifier
                // When
                .create(repo.findAll().collectList())

                // Then
                .expectNextMatches(list -> list.size() == 5)
                .verifyComplete();
    }
}
