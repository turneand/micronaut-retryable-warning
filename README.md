## retryable-issue

A simple micronaut app configured to run on micronaut 3.10.1 and 4.1.1 used to demonstrate a new warning appearing (trying to identify if a misconfiguration, a genuine issue, or a regression)

To run with Micronaut 3.10.1, run:
```
mvnw clean test -f pom-3.10.1.xml
```

This prints out:
```
[INFO] Running com.example.DemoTest
08:39:07.883 [main] INFO  i.m.c.DefaultApplicationContext$RuntimeConfiguredEnvironment - Established active environments: [test]
08:39:08.750 [default-nioEventLoopGroup-1-2] INFO  com.example.SimpleController - Returning error
08:39:08.760 [custom-event-loop-nioEventLoopGroup-3-1] ERROR com.example.LoggingRetryPredicate - Client '/': Internal Server Error
08:39:18.769 [default-nioEventLoopGroup-1-3] INFO  com.example.SimpleController - Returning error
08:39:18.770 [custom-event-loop-nioEventLoopGroup-3-2] ERROR com.example.LoggingRetryPredicate - Client '/': Internal Server Error
08:39:33.779 [default-nioEventLoopGroup-1-4] INFO  com.example.SimpleController - returning success
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 26.438 s - in com.example.DemoTest
```

To run with Micronaut 4.1.1, run:
```
mvnw clean test -f pom-4.1.1.xml
```

This prints out:
```
[INFO] Running com.example.DemoTest
08:40:37.604 [main] INFO  i.m.c.DefaultApplicationContext$RuntimeConfiguredEnvironment - Established active environments: [test]
08:40:38.514 [default-nioEventLoopGroup-1-2] INFO  com.example.SimpleController - Returning error
08:40:38.526 [custom-event-loop-nioEventLoopGroup-3-1] ERROR com.example.LoggingRetryPredicate - Client '/': Internal Server Error
08:40:48.535 [custom-event-loop-nioEventLoopGroup-3-1] WARN  i.n.channel.DefaultChannelPipeline - An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.
io.netty.handler.timeout.ReadTimeoutException: null
08:40:48.538 [default-nioEventLoopGroup-1-3] INFO  com.example.SimpleController - Returning error
08:40:48.539 [custom-event-loop-nioEventLoopGroup-3-2] ERROR com.example.LoggingRetryPredicate - Client '/': Internal Server Error
08:41:03.552 [default-nioEventLoopGroup-1-3] INFO  com.example.SimpleController - returning success
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 26.46 s -- in com.example.DemoTest
```