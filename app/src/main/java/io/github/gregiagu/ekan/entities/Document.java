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

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;
    private String documentType;
    private String description;
    private LocalDate registerDate;
    private LocalDate lastUpdate;

    public Document() {}

    public Document(
            String documentType,
            String description,
            String registerDate,
            String updateDate
    ) {
        this.documentType = documentType;
        this.description  = description;
        this.registerDate = LocalDate.parse(registerDate);
        this.lastUpdate = LocalDate.parse(updateDate);
    }

    public Document(
            String documentType,
            String description,
            LocalDate registerDate,
            LocalDate updateDate
    ) {
        this.documentType = documentType;
        this.description  = description;
        this.registerDate = registerDate;
        this.lastUpdate = updateDate;
    }

    public Document(
            Document source
    ) {
        this.documentType = source.documentType;
        this.description  = source.description;
        this.registerDate = source.registerDate;
        this.lastUpdate = source.lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setDocumentType(String documentType) {
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

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setUpdateDate(String updateDate) {
        this.lastUpdate = LocalDate.parse(updateDate);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentType=" + documentType +
                ", description='" + description + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}

