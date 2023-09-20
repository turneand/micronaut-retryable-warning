package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SimpleController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private int counter;

    @Get(uri = "/sayHelloError")
    public HttpResponse sayHelloError() {
        if (++counter < 3) {
            log.info("Returning error");
            return HttpResponse.serverError();
        }
        log.info("returning success");
        return HttpResponse.ok("hello-no-error");
    }
}