package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.dto.AllRecipientsDto;
import io.github.gregiagu.ekan.dto.RecipientDto;
import io.github.gregiagu.ekan.entities.Recipient;
import io.github.gregiagu.ekan.service.RecipientService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EkanRestController {

    private final Logger logger;
    private ModelMapper modelMapper;

    private RecipientService recipientService;

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

    @GetMapping("/recipient/{id}")
    public RecipientDto getRecipient(@PathVariable long id) {

        logger.atDebug()
                .log("Get Recipient Id: " + id);
        Recipient referenceById = recipientService.getReferenceById(id);

        return modelMapper.map(referenceById, RecipientDto.class);
    }

    @GetMapping("/recipient/all")
    public List<AllRecipientsDto> getAllRecipients() {
        logger.atDebug()
                .log("Getting All Recipients");
        List<Recipient> allRecipients = recipientService.getAllRecipients();
        return allRecipients.stream()
                .map((element) -> modelMapper.map(element, AllRecipientsDto.class))
                .toList();
    }

}
