package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.javalin.Javalin;

//@SpringBootApplication
public class P1ChrisProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(P1ChrisProjectApplication.class, args)
		

	Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
			).start(3000);
	}
}
