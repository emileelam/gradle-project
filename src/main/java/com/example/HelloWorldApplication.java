package com.example;

import com.example.health.TemplateHealthCheck;
import com.example.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    // This method is used to configure aspects of the app required before the app is run
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

    }

    // Reads template and default name from HelloWorldConfiguration instance
    // Creates a new HelloWorldResource instance and adds it to the apps Jersey environment
    // When the app starts, we create a new instance of resource class with params from config file and hand it off to Environment
    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        // Create new instance of healthCheck with appropriate params and add to Environment
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
