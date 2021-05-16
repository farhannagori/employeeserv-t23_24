package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.CustomError;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exceptions.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.exceptions.InvalidRequestException;
import com.paypal.bfs.test.employeeserv.repository.AddressRepository;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.service.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeValidationService employeeValidationService;

    /**
     * @param employee to insert
     * @return Inserted Employee
     * @throws InvalidRequestException
     */
    @Transactional
    @Override
    public Employee addEmployee(Employee employee) throws InvalidRequestException {

        employeeValidationService.validateEmployee(employee);
        EmployeeEntity employeeEntity = EmployeeUtils.convertToEmployeeEntity(employee);
        employeeEntity.setAddress(addressRepository.save(employeeEntity.getAddress()));
        return EmployeeUtils.convertToEmployee(employeeRepository.save(employeeEntity));
    }


    /**
     * @param id to be searched for employees
     * @return Employee Resource associated to that id
     * throws EmployeeNotFoundException if employee is not found in db
     */
    @Override
    public Employee retrieveEmployee(Integer id) throws EmployeeNotFoundException {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployee.get();
            return EmployeeUtils.convertToEmployee(employeeEntity);
        } else {
            throw new EmployeeNotFoundException(new CustomError(HttpStatus.NOT_FOUND, "Employee Not Found", null));
        }
    }

}
