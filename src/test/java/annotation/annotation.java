package annotation;

import cucumber.api.java.en.Given;
import cucumber.api.java.is.En;

public class annotation implements En {
    public annotation() {
        Given("I have (\\d+) cukes in my belly"), (Integer cukes) -> {
            System.out.format("Cukes: %n\n", cukes);
        });
    }

}