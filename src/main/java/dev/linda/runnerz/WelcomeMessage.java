package dev.linda.runnerz;

import org.springframework.stereotype.Component;

// this annotation means this class is available to spring
@Component
public class WelcomeMessage {

    public String getWelcomeMessage(String name) {
//        return "Hello " + name + "! Welcome to your 1st Springboot application.";

        // Java template literal
        return String.format("Hello %s !!", name);
    }
}
