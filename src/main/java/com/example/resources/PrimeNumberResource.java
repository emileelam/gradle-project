package com.example.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.api.CheckNumber;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/prime-number")
@Produces(MediaType.APPLICATION_JSON)
public class PrimeNumberResource {
    private int number;
    private String result;

    public PrimeNumberResource(String result) {
        this.number = number;
        this.result = result;
    }

    @GET
    @Timed
    public CheckNumber checkNumber(@QueryParam("no") int no) {
        final String value = "test";
        final int number = no;
        return new CheckNumber(number, result);
    }
}
