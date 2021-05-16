package com.paypal.bfs.test.employeeserv.exceptions;

import com.paypal.bfs.test.employeeserv.CustomError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Setter
@Getter
public class EmployeeNotFoundException extends RuntimeException {
    private CustomError customError;
}
