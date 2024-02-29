package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private DocumentType documentType;
    private String description;
    private LocalDate registerDate;
    private LocalDate updateDate;

    public Document() {}

    public Document(
            DocumentType documentType,
            String description,
            String registerDate,
            String updateDate
    ) {
        this.documentType = documentType;
        this.description  = description;
        this.registerDate = LocalDate.parse(registerDate);
        this.updateDate   = LocalDate.parse(updateDate);
    }

    public Document(
            DocumentType documentType,
            String description,
            LocalDate registerDate,
            LocalDate updateDate
    ) {
        this.documentType = documentType;
        this.description  = description;
        this.registerDate = registerDate;
        this.updateDate   = updateDate;
    }

    public Document(
            Document source
    ) {
        this.documentType = source.documentType;
        this.description  = source.description;
        this.registerDate = source.registerDate;
        this.updateDate   = source.updateDate;
    }

    public Long getId() {
        return id;
    }

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

    public void setRegisterDate(String registerDate) {
        this.registerDate = LocalDate.parse(registerDate);
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = LocalDate.parse(updateDate);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentType=" + documentType +
                ", description='" + description + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}

