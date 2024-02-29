package io.github.gregiagu.ekan.dto;

import io.github.gregiagu.ekan.entities.DocumentType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DocumentDto {

    private DocumentType documentType;
    private String description;
    private LocalDate registerDate;
    private LocalDate updateDate;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
