package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipients")
public class Recipient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String ownName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate updateDate;

    @OneToMany
    private List<Document> documentList;


    public Recipient() {}

    public Recipient(
            String ownName,
            String telephoneNumber,
            LocalDate birthdate,
            LocalDate registerDate,
            LocalDate updateDate
    ) {
        this.ownName         = ownName;
        this.telephoneNumber = telephoneNumber;
        this.birthdate       = birthdate;
        this.registerDate    = registerDate;
        this.updateDate      = updateDate;
    }

    public Recipient(
            String ownName,
            String telephoneNumber,
            String birthdate,
            String registerDate,
            String updateDate
    ) {
        this.ownName         = ownName;
        this.telephoneNumber = telephoneNumber;
        this.birthdate       = LocalDate.parse(birthdate);
        this.registerDate    = LocalDate.parse(registerDate);
        this.updateDate      = LocalDate.parse(updateDate);
    }

    public Recipient(
        Recipient source
    ) {
        this.ownName         = source.ownName;
        this.telephoneNumber = source.telephoneNumber;
        this.birthdate       = source.birthdate;
        this.registerDate    = source.registerDate;
        this.updateDate      = source.updateDate;
    }

    public Long getId() {
        return id;
    }

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

    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate);
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

    public List<Document> getDocumentList() {
        if (documentList == null) {
            documentList = new ArrayList<>();
        }
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        if (documentList == null) {
            documentList = new ArrayList<>();
        }
        this.documentList = documentList;
    }

    public void addDocument(Document doc) {
        if (documentList == null) {
            documentList = new ArrayList<>();
        }
        documentList.add(doc);
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "id=" + id +
                ", ownName='" + ownName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
