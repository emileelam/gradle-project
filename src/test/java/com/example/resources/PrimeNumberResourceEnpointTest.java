package com.example.resources;

import com.example.api.CheckNumber;
import com.fasterxml.jackson.databind.ObjectReader;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumberResourceEnpointTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PrimeNumberResource("It is a prime number!!"))
            .build();

    @Test
    public void primeNumber() throws IOException {

        String resp = resources.client().target("/prime-number")
                .queryParam("no", 2)
                .request().get(String.class);

        String json = "{\"number\": 2, \"result\": \"It is a prime number!!\"}";

        ObjectReader reader = resources.getObjectMapper().reader(CheckNumber.class);

        CheckNumber actual = reader.readValue(resp);
        CheckNumber expected = reader.readValue(json);

        assertThat(actual.getNumber())
                .isEqualTo(expected.getNumber())
                .isEqualTo(2);

        assertThat(actual.getResult())
                .isEqualTo(expected.getResult())
                .isEqualTo("It is a prime number!!");

    }

    @Test
    public void absentNumber() {
        CheckNumber actual = resources.client().target("/prime-number")
                .request().get(CheckNumber.class);
        CheckNumber expected = new CheckNumber(0, "It is not a prime number");
        assertThat(actual.getNumber()).isEqualTo(expected.getNumber());
        assertThat(actual.getResult()).isEqualTo(expected.getResult());
    }

}