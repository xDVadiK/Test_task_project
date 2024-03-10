package com.example.test_task_project.repository;

import com.example.test_task_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM employee")
    List<Employee> getAllEmployee();

    @Query(nativeQuery = true, value = "SELECT * FROM employee WHERE id = :employeeId")
    Employee findById(@Param("employeeId") int employeeId);

    @Query(nativeQuery = true, value = "SELECT * FROM employee WHERE birthdate BETWEEN :from AND :to")
    List<Employee> findBetween(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
