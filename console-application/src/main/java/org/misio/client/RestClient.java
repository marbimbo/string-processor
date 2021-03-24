package org.misio.client;

import org.misio.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;

@Component
public class RestClient {

    private WebClient client;
    private String baseUrl;
    private String queryParam;
    private long timeoutSeconds;

    @Value("${baseUrl}")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Value("${queryParam}")
    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    @Value("${timeoutSeconds}")
    public void setTimeoutSeconds(long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @PostConstruct
    private void initWebClient() {
        client = WebClient.create(baseUrl);
    }

    public PairResponse getPairResponse(String requestedString) {
        WebClient.RequestHeadersSpec<?> requestSpec = client.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam(queryParam, requestedString)
                        .build());

        Mono<PairResponse> monoPair = requestSpec.exchangeToMono(response -> {
            if (response.statusCode().is2xxSuccessful()) {
                return response.bodyToMono(StringIntegerPair.class);
            } else if (response.statusCode().is4xxClientError()) {
                return Mono.just(new ClientError(response.statusCode()));
            } else {
                return Mono.just(new ServerError(response.statusCode()));
            }
        });

        return monoPair
                .onErrorReturn(new ConnectionError("is REST service started?"))
                .block(Duration.ofSeconds(timeoutSeconds));
    }
}
