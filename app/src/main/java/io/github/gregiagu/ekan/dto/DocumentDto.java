package io.github.gregiagu.ekan.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DocumentDto implements Serializable {

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
