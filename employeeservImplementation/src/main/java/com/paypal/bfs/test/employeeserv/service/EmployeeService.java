package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Employee service for CRUD operation
 */
public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee retrieveEmployee(Integer id);
}
