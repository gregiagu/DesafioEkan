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
    public ResponseEntity<ResponseRecipientDto> getRecipient(@PathVariable long id) {

        logger.atDebug()
                .log("Get Recipient Id: " + id);
        Recipient referenceById = recipientService.getReferenceById(id);

        return new ResponseEntity<>(
                modelMapper.map(referenceById, ResponseRecipientDto.class),
                HttpStatus.OK
        );
    }

    @GetMapping("/recipient/all")
    public ResponseEntity<List<GetAllRecipientsDto>> getAllRecipients() {
        logger.atDebug()
                .log("Getting All Recipients");
        List<Recipient> allRecipients = recipientService.getAllRecipients();
        return new ResponseEntity<>(
                allRecipients.stream()
                        .map((element) -> modelMapper.map(element, GetAllRecipientsDto.class))
                        .toList(),
                HttpStatus.OK
        );
    }

    @PostMapping("/recipient")
    public ResponseEntity<Recipient> createRecipient(
            @RequestBody final CreatingRecipientRequestDto recipient
    ){
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
        return new ResponseEntity<>(
                recipientService.updateRecipient(id, targetRecipient),
                HttpStatus.OK
        );
    }
}
