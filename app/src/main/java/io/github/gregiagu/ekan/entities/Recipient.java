package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipients")
public class Recipient implements Serializable {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String fullName;
    private String telephoneNumber;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private LocalDate lastUpdate;

    @Builder.Default
    @OneToMany(
            mappedBy = "recipient",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
            orphanRemoval = true
    )
    private List<Document> documentList = new ArrayList<>();

    public void addDocument(Document doc) {
        documentList.add(doc);
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "id=" + id +
                ", ownName='" + fullName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", registerDate=" + registerDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
