package com.paypal.bfs.test.employeeserv.exceptions;

import com.paypal.bfs.test.employeeserv.CustomError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class EmployeeServExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new CustomError(HttpStatus.BAD_REQUEST, ex.toString(), null));
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EmployeeNotFoundException ex) {
        return buildResponseEntity(ex.getCustomError());
    }

    @ExceptionHandler(InvalidRequestException.class)
    protected ResponseEntity<Object> handleBadRequstException(
            InvalidRequestException ex) {
        return buildResponseEntity(ex.getCustomError());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGenericException(
            Exception ex) {
        CustomError customError = new CustomError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Servier Error", null);
        return buildResponseEntity(customError);
    }


    private ResponseEntity<Object> buildResponseEntity(CustomError apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }


}
