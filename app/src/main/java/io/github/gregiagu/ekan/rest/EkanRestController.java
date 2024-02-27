package io.github.gregiagu.ekan.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EkanRestController {

    @GetMapping("/health")
    public String getHealth() {
        return LocalDateTime
                .now()
                .toString()
                ;
    }
}
