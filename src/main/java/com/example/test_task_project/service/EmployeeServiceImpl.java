package com.example.test_task_project.service;

import com.example.test_task_project.repository.EmployeeRepository;
import com.example.test_task_project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(int id) {
        Employee employee = employeeRepository.findById(id);
        if(employee == null) {
            System.out.println("The employee with the id = " + id + " is not in the database");
        }
        return employee;
    }

    @Override
    public Map<String, List<Employee>> groupByName() {
        List<Employee> employees = employeeRepository.getAllEmployee();
        return employees.stream().collect(Collectors.groupingBy(Employee::getName));
    }

    @Override
    public List<Employee> findBetween(String from, String to) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDateFrom = LocalDate.parse(from, formatter);
            LocalDate localDateTo = LocalDate.parse(to, formatter);
            if(!localDateFrom.isBefore(localDateTo)) {
                System.out.println("The date setting the initial boundary of the interval must be before the date setting the final boundary of the interval.");
                return null;
            }
            return employeeRepository.findBetween(localDateFrom, localDateTo);
        } catch (Exception e) {
            System.out.println("The date was entered incorrectly. Enter the date in the format (yyyy-MM-dd)");
            return null;
        }
    }

    @Override
    public List<Employee> findBetween(LocalDate from, LocalDate to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return findBetween(from.format(formatter), to.format(formatter));
    }
}
