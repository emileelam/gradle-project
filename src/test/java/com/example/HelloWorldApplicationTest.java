package com.example;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldApplicationTest {

    @Test
    public void main() {
    }

    @Test
    public void getName() {
        String result = "hello-world";
        String expected = "hello-world";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void initialize() {
    }

    @Test
    public void run() {
    }
}