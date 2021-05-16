package com.paypal.bfs.test.employeeserv.resource.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> employeeGetById(Integer id) {
        return new ResponseEntity<>(employeeService.retrieveEmployee(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> insertEmployee(Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }
}
