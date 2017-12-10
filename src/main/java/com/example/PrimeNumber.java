package com.example;

public class PrimeNumber {
    public static void main(String[] args) {
        isPrime(1);
    }

    public static boolean isPrime(int n) {
        if(n == 2 || n == 3 || n == 5 || n == 7) {
            System.out.println("True");
            return true;
        } else {
            System.out.println("False");
            return false;
        }
    }
}
