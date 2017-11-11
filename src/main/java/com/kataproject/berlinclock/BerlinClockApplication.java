package com.kataproject.berlinclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kataproject.berlinclock")
public class BerlinClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(BerlinClockApplication.class, args);
	}
}
