package com.example.test_task_project;

import com.example.test_task_project.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private EmployeeServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Search for an employee by ID = 1:");
		System.out.println(service.findById(1));
		System.out.println();
		System.out.println("Search for an employee by ID = 100:");
		System.out.println(service.findById(100));
		System.out.println();
		System.out.println("Grouping employees by name:");
		System.out.println(service.groupByName());
		System.out.println();
		System.out.println("Search for employees whose dates are in the interval from \"2001-01-01\" to \"2010-01-01\":");
		System.out.println(service.findBetween("2001-01-01", "2010-09-09"));
		System.out.println();
		System.out.println("Search for employees whose dates are in the interval from \"200-01-01\" to \"2010-01-01\":");
		System.out.println(service.findBetween("200-01-01", "2010-09-09"));
		System.out.println();
		System.out.println("Search for employees whose dates are in the interval from \"2010-01-01\" to \"2001-01-01\":");
		System.out.println(service.findBetween("2010-01-01", "2001-01-01"));
		System.out.println();
		System.out.println("Search for employees whose dates are in the interval from \"2001-01-01\" to \"2010-01-01\":");
		System.out.println(service.findBetween(LocalDate.of(2001, 1, 1), LocalDate.of(2010, 1, 1)));
	}
}
