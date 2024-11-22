package dev.linda.runnerz;

import dev.linda.runnerz.run.Location;
import dev.linda.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class RunnerzApplication {

    private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

    // the main method is the entry point for this application
    public static void main(String[] args) {
        SpringApplication.run(RunnerzApplication.class, args);

        var displayWelcomeMessage = new WelcomeMessage();
        System.out.println(displayWelcomeMessage.getWelcomeMessage("Linda"));

        // we can add logs, like console.log

        // different types of log, like log.error, log.warn, etc
        log.info(">>> " + "Application started successfully <<<");
    }

    // a bean is an instance of a class with some metadata attached to it
    @Bean
    // CommandLineRunner runs after the application has started
    CommandLineRunner commandLineRunner() {
        return args -> {
            Run run = new Run(1, "My 1st run", LocalDateTime.now(), LocalDateTime.now().plus(3, ChronoUnit.HOURS), 15, Location.OUTDOOR);
            log.info(">>> Run record : " + run);
        };
    }

}
