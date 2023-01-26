package com.project.estoque.model.handler;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.estoque.model.error.MessageError;
import com.project.estoque.model.exception.*;
import com.project.estoque.utils.DateConvertor;

@ControllerAdvice
public class RestExceptionHandler {

    @Validated
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageError> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String dateTime = DateConvertor.converterDateForDateAndTime(new Date());
        MessageError erro = new MessageError(dateTime, 404, "Not Found", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @Valid
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<MessageError> handlerBadRequestException(ResourceBadRequestException ex) {
        String dateTime = DateConvertor.converterDateForDateAndTime(new Date());
        MessageError erro = new MessageError(dateTime, 400, "Bad Request", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @Valid
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageError> handlerBadRequestException(Exception ex) {
        String dateTime = DateConvertor.converterDateForDateAndTime(new Date());
        MessageError erro = new MessageError(dateTime, 500, "Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
