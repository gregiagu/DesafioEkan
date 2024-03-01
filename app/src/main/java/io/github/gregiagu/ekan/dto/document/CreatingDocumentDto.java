package io.github.gregiagu.ekan.dto.document;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatingDocumentDto {
    private String documentType;
    private String description;
    private LocalDate registerDate;
    private LocalDate lastUpdate;
}
