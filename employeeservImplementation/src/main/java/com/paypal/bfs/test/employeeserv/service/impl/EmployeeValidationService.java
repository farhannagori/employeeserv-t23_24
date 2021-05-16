package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.CustomError;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exceptions.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeValidationService {

    public void validateEmployee(Employee employee) {

        List<CustomError> list = new ArrayList<>();
        if (employee.getFirstName() == null || employee.getFirstName().isEmpty() || employee.getFirstName().length() > 255)
            list.add(new CustomError(null, "First Name is Invalid", null));
        if (employee.getLastName() == null || employee.getLastName().isEmpty() || employee.getLastName().length() > 255)
            list.add(new CustomError(null, "Last Name is Invalid", null));
        if (employee.getDateOfBirth() == null || employee.getDateOfBirth().isEmpty() || employee.getDateOfBirth().length() > 10)
            list.add(new CustomError(null, "Date Of Birth is Invalid", null));
        if (employee.getAddress().getCity() == null || employee.getAddress().getCity().isEmpty() || employee.getAddress().getCity().length() > 255)
            list.add(new CustomError(null, "City is Invalid", null));
        if (employee.getAddress().getCountry() == null || employee.getAddress().getCountry().isEmpty() || employee.getAddress().getCountry().length() > 255)
            list.add(new CustomError(null, "Country is Invalid", null));
        if (employee.getAddress().getState() == null || employee.getAddress().getState().isEmpty() || employee.getAddress().getState().length() > 255)
            list.add(new CustomError(null, "State Invalid", null));
        if (employee.getAddress().getZipCode() == null || String.valueOf(employee.getAddress().getZipCode()).length() > 10)
            list.add(new CustomError(null, "Zipcode is Invalid", null));
        if (employee.getAddress().getLine1() == null || employee.getAddress().getLine1().isEmpty() || employee.getAddress().getLine1().length() > 500)
            list.add(new CustomError(null, "Address Line1 is Invalid", null));

        if (list.size() > 0) {
            throw new InvalidRequestException(new CustomError(HttpStatus.BAD_REQUEST, "Invalid Request", list));
        }
    }
}
