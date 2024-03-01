package io.github.gregiagu.ekan.dto.recipient;

import io.github.gregiagu.ekan.dto.document.ResponseDocumentDto;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRecipientDto implements Serializable {

    private Long id;
    private String fullName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;
    private List<ResponseDocumentDto> documentList;
}
