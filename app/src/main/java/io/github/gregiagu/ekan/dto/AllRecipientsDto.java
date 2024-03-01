package io.github.gregiagu.ekan.dto;

import java.time.LocalDate;

public class AllRecipientsDto {
    private String ownName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;

    public AllRecipientsDto() {

    }
    public AllRecipientsDto(String ownName, String telephoneNumber, LocalDate birthdate, LocalDate registerDate, LocalDate lastUpdate) {
        this.ownName = ownName;
        this.telephoneNumber = telephoneNumber;
        this.birthdate = birthdate;
        this.registerDate = registerDate;
        this.lastUpdate = lastUpdate;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "AllRecipientsDto{" +
                "ownName='" + ownName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", registerDate=" + registerDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
