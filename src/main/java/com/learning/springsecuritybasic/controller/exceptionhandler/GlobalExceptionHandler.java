package com.learning.springsecuritybasic.controller.exceptionhandler;

import com.learning.springsecuritybasic.model.dto.error.ErrorMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Object> handleConflict(Exception exception, WebRequest request) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setErrorMessage("Unknown error");
        errorMessageDto.setTechnicalErrorMessage(exception.getMessage());
        return handleExceptionInternal(exception, errorMessageDto, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
