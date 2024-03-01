package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

