package io.github.gregiagu.ekan.repositories;

import io.github.gregiagu.ekan.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepo extends JpaRepository<Recipient, Long> {

}
