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
public class RecipientDto implements Serializable {

    private Long id;
    private String fullName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;
    private List<DocumentDto> documentList;
}
