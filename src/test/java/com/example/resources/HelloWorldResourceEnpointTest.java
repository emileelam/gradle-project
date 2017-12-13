package com.example.resources;

import com.example.api.Saying;
import com.fasterxml.jackson.databind.ObjectReader;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldResourceEnpointTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Hello, %s!", "Stranger"))
            .build();

    @Test
    public void helloWorldDropwizard() throws IOException {
        String resp = resources.client().target("/hello-world")
                .queryParam("name", "dropwizard")
                .request().get(String.class);

        String json = "{\"id\": 1, \"content\": \"Hello, dropwizard!, \"result\": false\" }";

        ObjectReader reader = resources.getObjectMapper().reader(Saying.class);

        Saying actual = reader.readValue(resp);
        Saying expected = reader.readValue(json);

        assertThat(actual.getId())
                .isEqualTo(expected.getId())
                .isEqualTo(1);

        assertThat(actual.getContent())
                .isEqualTo(expected.getContent())
                .isEqualTo("Hello, dropwizard!");

        assertThat(actual.getResult())
                .isEqualTo(expected.getResult())
                .isEqualTo(false);

    }

    @Test
    public void absentName() {
        Saying actual = resources.client().target("/hello-world")
                .request().get(Saying.class);
        Saying expected = new Saying(1, "Hello, Stranger!", false);
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getContent()).isEqualTo(expected.getContent());
        assertThat(actual.getResult()).isEqualTo(expected.getResult());
    }
}