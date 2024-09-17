package com.andygalem.Job.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		System.out.println("");
		SpringApplication.run(JobApplication.class, args);
		System.out.println("Welcome to job-application");
	}

}
