package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;
import java.time.Duration;
import reactor.core.publisher.Mono;

@MicronautTest
class DemoTest {
    @Inject
    private MyClient client;
    
    @Test
    void testItWorks() {
        Assertions.assertEquals("hello-no-error", client.sayHelloError().block(Duration.ofSeconds(120)));
    }

    @Retryable(attempts = "5", delay = "5s", predicate = LoggingRetryPredicate.class)
    @Client("/")
    public interface MyClient {
        @Get(uri = "/sayHelloError")
        Mono<String> sayHelloError();
    }
}
