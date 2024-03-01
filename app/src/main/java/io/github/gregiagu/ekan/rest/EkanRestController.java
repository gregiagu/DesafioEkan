package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.dto.AllRecipientsDto;
import io.github.gregiagu.ekan.dto.RecipientDto;
import io.github.gregiagu.ekan.entities.Recipient;
import io.github.gregiagu.ekan.exceptions.RecipientNotFoundException;
import io.github.gregiagu.ekan.faults.RecipientNotFoundFault;
import io.github.gregiagu.ekan.service.RecipientService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EkanRestController {

    private final Logger logger;
    private final ModelMapper modelMapper;
    private final RecipientService recipientService;

    @Autowired
    public EkanRestController(
            ModelMapper modelMapper,
            RecipientService recipientService
    ) {
        this.modelMapper = modelMapper;
        this.recipientService = recipientService;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @GetMapping("/health")
    public String getHealth() {
        return LocalDateTime
                .now()
                .toString()
                ;
    }

    @GetMapping("/exception")
    public String getException() throws Exception {
        throw new Exception("Generic exception");
    }

    @GetMapping("/recipient/{id}")
    public ResponseEntity<RecipientDto> getRecipient(@PathVariable long id) {

        logger.atDebug()
                .log("Get Recipient Id: " + id);
        Recipient referenceById = recipientService.getReferenceById(id);

        return new ResponseEntity<>(
                modelMapper.map(referenceById, RecipientDto.class),
                HttpStatus.OK
        );
    }

    @GetMapping("/recipient/all")
    public ResponseEntity<List<AllRecipientsDto>> getAllRecipients() {
        logger.atDebug()
                .log("Getting All Recipients");
        List<Recipient> allRecipients = recipientService.getAllRecipients();
        return new ResponseEntity<>(
                allRecipients.stream()
                        .map((element) -> modelMapper.map(element, AllRecipientsDto.class))
                        .toList(),
                HttpStatus.OK
        );
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
