package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.dto.RecipientDto;
import io.github.gregiagu.ekan.entities.Recipient;
import io.github.gregiagu.ekan.service.RecipientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class EkanRestController {


    private ModelMapper modelMapper;

    private RecipientService recipientService;

    @Autowired
    public EkanRestController(
            ModelMapper modelMapper,
            RecipientService recipientService
    ) {
        this.modelMapper = modelMapper;
        this.recipientService = recipientService;
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

//        Recipient firstRecipient = new Recipient(
//                "First Recipient",
//                "+5511964442320",
//                "2010-05-13",
//                "2013-05-13",
//                "2021-09-12"
//        );
//
//        firstRecipient.addDocument(new Document(DocumentType.CPF, "33344455511", "2010-02-05", "2010-02-15"));
//        firstRecipient.addDocument(new Document(DocumentType.RG, "553334446", "2010-02-05", "2010-02-15"));
//
//        RecipientDto map = modelMapper.map(firstRecipient, RecipientDto.class);
//        return map;


        Recipient referenceById = recipientService.getReferenceById(id);

        return modelMapper.map(referenceById, RecipientDto.class);
    }

}
