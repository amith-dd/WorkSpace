package com.ty.workSpace_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorkSpaceManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(WorkSpaceManagementApplication.class, args);

	}

}
