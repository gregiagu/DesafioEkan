package io.github.gregiagu.ekan.service;

import io.github.gregiagu.ekan.dto.recipient.CreatingRecipientRequestDto;
import io.github.gregiagu.ekan.dto.recipient.ResponseRecipientDto;
import io.github.gregiagu.ekan.entities.Document;
import io.github.gregiagu.ekan.entities.Recipient;
import io.github.gregiagu.ekan.exceptions.RecipientNotFoundException;
import io.github.gregiagu.ekan.repositories.RecipientRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipientServiceImpl implements RecipientService{

    private final RecipientRepo recipientRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public RecipientServiceImpl(
            ModelMapper modelMapper,
            RecipientRepo recipientRepo
    ) {
        super();
        this.modelMapper = modelMapper;
        this.recipientRepo = recipientRepo;
    }

    @Override
    public Recipient getReferenceById(long id) {
       return recipientRepo
                .findById(id)
                .orElseThrow(
                        () -> new RecipientNotFoundException("Not found!")
                );

    }

    @Override
    public List<Recipient> getAllRecipients() {
        return recipientRepo
                .findAll()
                ;
    }

    @Override
    public Recipient create(CreatingRecipientRequestDto recipient) {
        Recipient entity = modelMapper.map(recipient, Recipient.class);
        return recipientRepo.save(entity);
    }

    @Override
    public ResponseRecipientDto updateRecipient(long id, CreatingRecipientRequestDto targetRecipient) {
        Recipient recipient = recipientRepo.findById(id).get();
        recipient.setFullName(targetRecipient.getFullName());
        recipient.setTelephoneNumber(targetRecipient.getTelephoneNumber());
        recipient.setBirthdate(targetRecipient.getBirthdate());
        recipient.setRegisterDate(targetRecipient.getRegisterDate());
        recipient.setLastUpdate(targetRecipient.getLastUpdate());
        List<Document> docs = targetRecipient.getDocumentList().stream()
                .map(doc -> modelMapper.map(doc, Document.class))
                .toList();
        docs.forEach(recipient::addDocument);
        return modelMapper.map(
                recipientRepo.saveAndFlush(recipient),
                ResponseRecipientDto.class
        );
    }

    @Override
    public void deleteRecipient(long id) {
        recipientRepo.deleteById(id);
    }
}
