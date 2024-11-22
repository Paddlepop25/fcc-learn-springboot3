package dev.linda.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	// the main method is the entry point for this application
	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);

//		var displayWelcomeMessage = new WelcomeMessage();
//		System.out.println(displayWelcomeMessage.getWelcomeMessage("Linda"));

		// a bean is an instance of a class with some metadata attached to it

		// we can add logs, like console.log
		// different types of log, like log.error, log.warn, etc
		log.info(">>> Application started successfully <<<");
	}
}
