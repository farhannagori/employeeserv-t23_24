package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;

public class EmployeeUtils {


    public  static EmployeeEntity convertToEmployeeEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setDateOfBirth(employee.getDateOfBirth());
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(employee.getAddress().getCity());
        addressEntity.setCountry(employee.getAddress().getCountry());
        addressEntity.setState(employee.getAddress().getState());
        addressEntity.setZipCode(employee.getAddress().getZipCode());
        addressEntity.setLine2(employee.getAddress().getLine2());
        addressEntity.setLine1(employee.getAddress().getLine1());
        employeeEntity.setAddress(addressEntity);
        return employeeEntity;
    }

    public static Employee convertToEmployee(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setDateOfBirth(employeeEntity.getDateOfBirth());
        Address address = new Address();
        address.setCity(employeeEntity.getAddress().getCity());
        address.setCountry(employeeEntity.getAddress().getCountry());
        address.setState(employeeEntity.getAddress().getState());
        address.setZipCode(employeeEntity.getAddress().getZipCode());
        address.setLine2(employeeEntity.getAddress().getLine2());
        address.setLine1(employeeEntity.getAddress().getLine1());
        employee.setAddress(address);
        employee.setId(employeeEntity.getId());
        return employee;
    }
}
