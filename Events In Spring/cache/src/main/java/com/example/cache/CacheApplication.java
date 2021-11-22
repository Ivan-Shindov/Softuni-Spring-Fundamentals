package com.example.cache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CacheApplication implements CommandLineRunner {

	private StudentService service;

	public CacheApplication(StudentService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.initializeStudents();
	}
}
