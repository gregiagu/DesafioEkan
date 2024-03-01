package io.github.gregiagu.ekan.service;

import io.github.gregiagu.ekan.dto.document.ResponseDocumentDto;
import io.github.gregiagu.ekan.dto.recipient.CreatingRecipientRequestDto;
import io.github.gregiagu.ekan.dto.recipient.GetAllRecipientsDto;
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
    public ResponseRecipientDto getReferenceById(long id) {
        Recipient resp = recipientRepo
                .findById(id)
                .orElseThrow(
                        () -> new RecipientNotFoundException("Not found!")
                );
        ResponseRecipientDto targetRecipient = modelMapper.map(resp, ResponseRecipientDto.class);
        List<ResponseDocumentDto> list = resp.getDocumentList().stream()
                .map(doc -> modelMapper.map(doc, ResponseDocumentDto.class))
                .toList();
        targetRecipient.setDocumentList(list);
        return targetRecipient;
    }

    @Override
    public List<GetAllRecipientsDto> getAllRecipients() {
        List<Recipient> allRecipients = recipientRepo
                .findAll();
        return allRecipients.stream()
                .map((element) -> modelMapper.map(element, GetAllRecipientsDto.class))
                .toList();
    }

    @Override
    public ResponseRecipientDto create(CreatingRecipientRequestDto targetRecipient) {
        Recipient entity = modelMapper.map(targetRecipient, Recipient.class);
        entity.getDocumentList().forEach(
                document -> document.setRecipient(entity)
        );

        return modelMapper.map(
                recipientRepo.save(entity),
                ResponseRecipientDto.class
        );
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
