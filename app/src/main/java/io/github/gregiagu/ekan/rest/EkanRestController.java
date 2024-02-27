package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.entities.Beneficiario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EkanRestController {

    @GetMapping("/health")
    public String getHealth() {
        return LocalDateTime
                .now()
                .toString()
                ;
    }

    @GetMapping("/recipients")
    public List<Beneficiario> getRecipients() {
        return null;
    }
}
