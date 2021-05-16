package com.paypal.bfs.test.employeeserv;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Setter
@Getter
@AllArgsConstructor
public class CustomError {

    HttpStatus httpStatus;
    String message;
    List<CustomError> errors;
}
