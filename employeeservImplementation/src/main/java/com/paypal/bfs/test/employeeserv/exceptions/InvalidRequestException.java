package com.paypal.bfs.test.employeeserv.exceptions;

import com.paypal.bfs.test.employeeserv.CustomError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class InvalidRequestException extends  RuntimeException {
    private CustomError customError;

}
