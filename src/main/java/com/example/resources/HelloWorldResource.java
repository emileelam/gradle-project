package com.example.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

// Path tells Jersey that this resource is accessible from this URI
// Produces lets Jersey's content negotiation code know this resource is a json application
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private boolean primeNo;

    // Take two params, template is used to produce the saying
    // defaultName is used when the user declines to tell us their name
    // AtomicLong provides a cheap, thread safe way of generating unique ID's
    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.primeNo = primeNo;
    }

    @GET
    @Timed
    // QueryParam("name") tells Jersey to map the name param from the query string to the name param in the method
    // If request is /hello-world?name=Emilee sayHello will be called with Optional.of("Emilee")
    // If no name param in query sayHello with call Optional.absent()
    public Saying sayHello(@QueryParam("name")Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value, primeNo);
    }
}
