package org.misio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StringControllerIT {

    private static final String QUERY_PARAM = "s";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testShouldReturnNotFound() {
        String requestedString = "123";

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam(QUERY_PARAM, requestedString)
                        .build())
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void testShouldReturnOk() {
        String requestedString = "string1";

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam(QUERY_PARAM, requestedString)
                        .build())
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testShouldReturnBadRequest() {
        webTestClient.get()
                .exchange()
                .expectStatus().isBadRequest();
    }

}
