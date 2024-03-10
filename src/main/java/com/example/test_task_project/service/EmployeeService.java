package com.example.test_task_project.service;

import com.example.test_task_project.entity.Employee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee findById(int id);

    Map<String, List<Employee>> groupByName();

    List<Employee> findBetween(String from, String to);

    List<Employee> findBetween(LocalDate from, LocalDate to);
}