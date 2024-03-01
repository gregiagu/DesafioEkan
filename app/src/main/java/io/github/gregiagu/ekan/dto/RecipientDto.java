package io.github.gregiagu.ekan.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RecipientDto implements Serializable {

    private String fullName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;
    private List<DocumentDto> documentList = new ArrayList<>();

    @Override
    public String toString() {
        return "RecipientDto{" +
                "fullName='" + fullName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", registerDate=" + registerDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
