package com.ivoyant.internship_project_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InternshipProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(InternshipProject1Application.class, args);
	}

}
