package io.github.gregiagu.ekan.service;

import io.github.gregiagu.ekan.entities.Recipient;
import io.github.gregiagu.ekan.repositories.RecipientRepo;
import org.springframework.stereotype.Service;

@Service
public class RecipientServiceImpl implements RecipientService{

    private final RecipientRepo recipientRepo;


    public RecipientServiceImpl(RecipientRepo recipientRepo) {
        super();
        this.recipientRepo = recipientRepo;
    }

    @Override
    public Recipient getReferenceById(long id) {
       return recipientRepo
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Not found")
                );

    }
}
