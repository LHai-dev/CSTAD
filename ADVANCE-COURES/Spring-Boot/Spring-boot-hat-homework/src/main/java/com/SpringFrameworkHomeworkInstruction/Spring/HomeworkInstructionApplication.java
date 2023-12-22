package com.SpringFrameworkHomeworkInstruction.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomeworkInstructionApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkInstructionApplication.class, args);
	}

}
