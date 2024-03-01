package io.github.gregiagu.ekan.dto.document;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDocumentDto implements Serializable {

    private Long id;
    private String documentType;
    private String description;
    private LocalDate registerDate;
    private LocalDate lastUpdate;

    @Override
    public String toString() {
        return "DocumentDto{" +
                "documentType='" + documentType + '\'' +
                ", description='" + description + '\'' +
                ", registerDate=" + registerDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
