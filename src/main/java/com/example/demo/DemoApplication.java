package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Value("${message}")
	String message;

	@Value("${anothermessage}")
	String anothermessage;

	@Bean
	CommandLineRunner values() {
		return args -> {
			log.info("=> Message is: " + message);
			log.info("=> Anothermessage is: " + anothermessage);
		};
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				//.profiles("prod", "sprint")
				.run(args);
	}
}

@Component
class MyRunner implements CommandLineRunner {
	@Autowired
	private Environment environment;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));
	}
}

// Profile specific bean, will only run if dev0 is active
@Component
@Profile(value="dev0")
class MyRunnerDev0 implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("In development (dev0)");
	}
}

@Component
@Profile(value="sprint")
class MyRunnerSprint implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("In non-prod (sprint)");
	}
}

@Component
@Profile(value="prod")
class MyRunnerProd implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("In prod (prod)");
	}
}