package com.webgram.dao;

import com.webgram.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select emp from Employee emp where emp.isDeleted=false")
    List<Employee> getAllEmployee();

    Sexe findByGenre(String Genre);

}
