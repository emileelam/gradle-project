package com.example;

import org.junit.Assert;
import org.junit.Test;

public class PrimeNumberTest {
    @Test
    public void two() {
        boolean result = PrimeNumber.isPrime(2);
        boolean expected = true;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void three() {
        boolean result = PrimeNumber.isPrime(3);
        boolean expected = true;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void five() {
        boolean result = PrimeNumber.isPrime(5);
        boolean expected = true;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void seven() {
        boolean result = PrimeNumber.isPrime(7);
        boolean expected = true;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void minusOne() {
        boolean result = PrimeNumber.isPrime(-1);
        boolean expected = false;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void zero() {
        boolean result = PrimeNumber.isPrime(0);
        boolean expected = false;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void one() {
        boolean result = PrimeNumber.isPrime(1);
        boolean expected = false;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void four() {
        boolean result = PrimeNumber.isPrime(4);
        boolean expected = false;
        Assert.assertEquals(result, expected);
    }

}