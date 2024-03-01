package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.exceptions.RecipientNotFoundException;
import io.github.gregiagu.ekan.faults.RecipientNotFoundFault;
import io.github.gregiagu.ekan.service.RecipientService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger;

    @Autowired
    public GlobalExceptionHandler(
    ) {
        this.logger = LoggerFactory.getLogger(getClass());
    }
    @ExceptionHandler
    public ResponseEntity<RecipientNotFoundFault> RecipientNotFoundException(RecipientNotFoundException exception) {
        logger.atError().log("Recipient Not Found!");
        RecipientNotFoundFault fault = RecipientNotFoundFault.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(fault, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RecipientNotFoundFault> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        logger.atError().log("Bad Request!");
        RecipientNotFoundFault fault = RecipientNotFoundFault.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(fault, HttpStatus.BAD_REQUEST);
    }
}
