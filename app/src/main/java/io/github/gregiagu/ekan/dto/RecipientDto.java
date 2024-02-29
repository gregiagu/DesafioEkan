package io.github.gregiagu.ekan.dto;

import io.github.gregiagu.ekan.entities.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipientDto {
    private String ownName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate updateDate;

    private List<DocumentDto> documentList;

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public List<DocumentDto> getDocumentList() {
        if (documentList == null) {
            documentList = new ArrayList<>();
        }
        return documentList;
    }

    public void setDocumentList(List<DocumentDto> documentList) {
        if (documentList == null) {
            documentList = new ArrayList<>();
        }
        this.documentList = documentList;
    }
}
