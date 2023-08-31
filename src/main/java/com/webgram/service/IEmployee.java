package com.webgram.service;

import com.webgram.entity.Employee;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface IEmployee {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee employee);
    void  deletedEmployee(Long id);
    Employee getOneEmployee(Long id);
}
