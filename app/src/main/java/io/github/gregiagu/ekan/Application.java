package io.github.gregiagu.ekan;

import io.github.gregiagu.ekan.dto.RecipientDto;
import io.github.gregiagu.ekan.entities.Recipient;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper()
                ;
    }
}
