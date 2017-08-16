package com.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by anupamrakshit on 15/08/17.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.labs.controller","com.labs.mongo"})
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
