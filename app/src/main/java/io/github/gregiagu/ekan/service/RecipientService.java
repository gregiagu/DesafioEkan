package io.github.gregiagu.ekan.service;

import io.github.gregiagu.ekan.dto.recipient.CreatingRecipientRequestDto;
import io.github.gregiagu.ekan.dto.recipient.GetAllRecipientsDto;
import io.github.gregiagu.ekan.dto.recipient.ResponseRecipientDto;
import io.github.gregiagu.ekan.entities.Recipient;

import java.util.List;

public interface RecipientService {

    ResponseRecipientDto getReferenceById(long id);

    List<GetAllRecipientsDto> getAllRecipients();

    ResponseRecipientDto create(CreatingRecipientRequestDto recipient);

    ResponseRecipientDto updateRecipient(long id, CreatingRecipientRequestDto targetRecipient);

    void deleteRecipient(long id);
}
