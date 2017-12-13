package com.example.resources;

import com.example.api.CheckNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumberResourceTest {

    private PrimeNumberResource resource;

    @Before
    public void setUp() throws Exception {
        resource = new PrimeNumberResource("Test");
    }

    @Test
    public void checkIfNumber() {
        CheckNumber result = resource.checkNumber(1);
        Assert.assertEquals(result.getNumber(), 1);
    }
}