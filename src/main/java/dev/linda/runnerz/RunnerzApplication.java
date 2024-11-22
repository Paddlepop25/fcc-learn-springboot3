package dev.linda.runnerz;

import Messages.WelcomeMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);

		var displayWelcomeMessage = new WelcomeMessage();
		System.out.println(displayWelcomeMessage.getWelcomeMessage("Linda"));
	}
}
