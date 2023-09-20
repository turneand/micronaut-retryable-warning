package com.example;

import io.micronaut.retry.annotation.RetryPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LoggingRetryPredicate implements RetryPredicate {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean test(Throwable throwable) {
        log.error(throwable.getMessage());
        return true;
    }
}
