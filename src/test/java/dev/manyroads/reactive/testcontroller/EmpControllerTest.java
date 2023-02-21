package dev.manyroads.reactive.testcontroller;

import dev.manyroads.reactive.controller.EmpController;
import dev.manyroads.reactive.model.EmpRecord;
import dev.manyroads.reactive.repository.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

/**
 * Testing of EmpController
 */
@WebFluxTest(controllers = { EmpController.class })
public class EmpControllerTest {

    private static final String EMP_URI = "http://localhost:5000/all";

    @MockBean
    private EmpRepository mockEmpRepository;

    @Autowired
    private WebTestClient webTestClient;

    /**
     * Test total records in database by mocking the repository and comparing endpoint call with expectation
     */
    @Test
    void getAllEmployees() {

        // GIVEN we have data
        final EmpRecord e1 = new EmpRecord();
        final EmpRecord e2 = new EmpRecord();
        when(mockEmpRepository.findAll()).thenReturn(Flux.just(e1, e2));

        // WHEN the endpoint is called
        final WebTestClient.ResponseSpec response = webTestClient
                .get().uri(EMP_URI)
                .exchange();

        // THEN we get an OK response with list content
        checkEmpList(response, 2);
    }

    // ---- Methodes ----
    /**
     * Method to convert response parameter in to a reactor Flux. The Flux is subsequently asserted by the
     * StepVerifier
     *
     * @param response [WebTestClient]  : Response from endpoint called
     * @param expectedCount [integer]   : expected number of records
     */
    private void checkEmpList(final WebTestClient.ResponseSpec response, int expectedCount) {

        // When
        final Flux<EmpRecord> flux = response
                .expectStatus().isOk()
                .returnResult(EmpRecord.class)
                .getResponseBody();

        // Then
        StepVerifier.create(flux.collectList())
                .expectNextMatches(list -> list.size() == expectedCount)
                .verifyComplete();
    }
}
