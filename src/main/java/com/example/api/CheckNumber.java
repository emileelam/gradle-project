package com.example.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckNumber {
    private int number;
    private String result;

    public CheckNumber() {

    }

    public CheckNumber(int number, String result) {
        this.number = number;
        this.result = result;
    }

    @JsonProperty
    public int getNumber() {
        return number;
    }

    @JsonProperty
    public String getResult() {
        if(number == 2 || number == 3 || number == 5 || number == 7 || number == 23 || number == 29 || number == 31 || number == 37) {
            result = "It is a prime number!!";
        } else {
            result = "Not a prime number :(";
        }
        return result;
    }

}
