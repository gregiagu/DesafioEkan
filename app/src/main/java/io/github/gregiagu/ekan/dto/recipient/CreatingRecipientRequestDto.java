package io.github.gregiagu.ekan.dto.recipient;

import io.github.gregiagu.ekan.dto.document.CreatingDocumentDto;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatingRecipientRequestDto {
    private String fullName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;
    @Builder.Default
    private List<CreatingDocumentDto> documentList = new ArrayList<>();
}
