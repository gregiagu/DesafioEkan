package io.github.gregiagu.ekan.service;

import io.github.gregiagu.ekan.dto.AllRecipientsDto;
import io.github.gregiagu.ekan.entities.Recipient;

import java.util.List;

public interface RecipientService {

    Recipient getReferenceById(long id);

    List<Recipient> getAllRecipients();
}
