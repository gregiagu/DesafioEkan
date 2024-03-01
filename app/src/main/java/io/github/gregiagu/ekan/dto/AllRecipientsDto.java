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
public class AllRecipientsDto implements Serializable {

    private Long id;
    private String fullName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;

    @Override
    public String toString() {
        return "AllRecipientsDto{" +
                "ownName='" + fullName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", registerDate=" + registerDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
