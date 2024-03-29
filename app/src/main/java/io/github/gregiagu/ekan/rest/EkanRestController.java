package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.dto.recipient.GetAllRecipientsDto;
import io.github.gregiagu.ekan.dto.recipient.CreatingRecipientRequestDto;
import io.github.gregiagu.ekan.dto.recipient.ResponseRecipientDto;
import io.github.gregiagu.ekan.entities.Recipient;
import io.github.gregiagu.ekan.service.RecipientService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EkanRestController {

    private final Logger logger;
    private final RecipientService recipientService;

    @Autowired
    public EkanRestController(
            RecipientService recipientService
    ) {
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

    @GetMapping("/recipient/{id}")
    public ResponseEntity<ResponseRecipientDto> getRecipient(@PathVariable long id) {

        logger.atDebug()
                .log("Get Recipient Id: " + id);

        return new ResponseEntity<>(
                recipientService.getReferenceById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/recipient/all")
    public ResponseEntity<List<GetAllRecipientsDto>> getAllRecipients() {
        logger.atDebug()
                .log("Getting All Recipients");
        return new ResponseEntity<>(
                recipientService.getAllRecipients(),
                HttpStatus.OK
        );
    }

    @PostMapping("/recipient")
    public ResponseEntity<ResponseRecipientDto> createRecipient(
            @RequestBody final CreatingRecipientRequestDto recipient
    ){
        logger.atDebug()
                .log("Creating a new Recipient");
        return new ResponseEntity<>(
                recipientService.create(recipient),
                HttpStatus.OK
        );
    }

    @PutMapping("/recipient/{id}")
    public ResponseEntity<ResponseRecipientDto> updateRecipient(
            @PathVariable("id") long id,
            @RequestBody CreatingRecipientRequestDto targetRecipient
    ) {
        logger.atDebug()
                .log("Update Recipient Id: " + id);
        return new ResponseEntity<>(
                recipientService.updateRecipient(id, targetRecipient),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/recipient/{id}")
    public ResponseEntity<String> deleteRecipient(@PathVariable long id) {

        logger.atDebug()
                .log("Delete Recipient Id: " + id);
        recipientService.deleteRecipient(id);
        return new ResponseEntity<>(
                "Deleted Successfully",
                HttpStatus.OK
        );
    }
}
