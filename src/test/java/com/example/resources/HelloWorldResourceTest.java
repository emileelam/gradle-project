package com.example.resources;

import com.example.api.Saying;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class HelloWorldResourceTest {
    private HelloWorldResource resource;

    @Before
    public void setUp() {
        resource = new HelloWorldResource("Hello, %s", "Stranger");
    }

    @Test
    public void inStartsAtOne() {
        String name = "Em";
        Saying result = resource.sayHello(Optional.of(name));
        Assert.assertEquals(result.getId(), 1);
    }

    @Test
    public void idIncrementsByOne() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        Saying result2 = resource.sayHello(Optional.of("java"));
        Assert.assertEquals(result2.getId(), result.getId() + 1);
    }

    @Test
    public void absentNameReturnsDefault() {
        String name = null;
        Saying result = resource.sayHello(Optional.ofNullable(name));
        Assert.assertEquals(result.getContent(), ("Hello, Stranger"));
    }
    @Test
    public void sayHello() {
        String name = "Hello, Emilee";
        Saying result = resource.sayHello(Optional.of("Emilee"));
        Assert.assertEquals(result.getContent(), name);
    }
}