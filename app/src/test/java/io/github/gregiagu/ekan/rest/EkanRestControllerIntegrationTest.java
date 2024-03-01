package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.dto.AllRecipientsDto;
import io.github.gregiagu.ekan.dto.RecipientDto;
import io.github.gregiagu.ekan.exceptions.RecipientNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EkanRestControllerIntegrationTest {

    private static Logger logger;
    @Autowired
    MockMvc mvc;

    @Autowired
    ModelMapper modelMapper;

    @BeforeAll
    static void environmentSetUp() {
        logger = LoggerFactory.getLogger(EkanRestControllerIntegrationTest.class);
    }

    @Test
    void itShouldGetHealth() throws Exception {
        logger.atInfo().log("Getting /api/health endpoint");
        String timestamp = this.mvc.perform(
                        get("/api/health").contentType(MediaType.TEXT_PLAIN)
                )
                .andReturn()
                .getResponse()
                .getContentAsString();
        logger.atInfo().log("Timestamp: " + timestamp);
        Object localDateTime = LocalDateTime.parse(timestamp);
        assertThat(localDateTime)
                .isInstanceOf(LocalDateTime.class);
    }

    @Test
    void itShouldGetRecipient() throws Exception {
        int id = 1;
        logger.atInfo().log("Getting /api/recipient/" + id + " endpoint");
        String rawJson = this.mvc.perform(
                        get("/api/recipient/" + id)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn()
                .getResponse()
                .getContentAsString();

        Object map = modelMapper.map(rawJson, RecipientDto.class);
        assertThat(map)
                .isNotNull()
                .isInstanceOf(RecipientDto.class);
    }

    @Test
    void itShouldGetListRecipient() throws Exception {
        logger.atInfo().log("Getting /api/recipient/all" + " endpoint");
        String rawJson = this.mvc.perform(
                        get("/api/recipient/all")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn()
                .getResponse()
                .getContentAsString();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                ;

        Object map = modelMapper.map(rawJson, AllRecipientsDto.class);
        assertThat(map)
                .isNotNull()
                .isInstanceOf(AllRecipientsDto.class);
    }

    @Test
    void itShouldThrownGenericException() throws Exception {
         assertThatExceptionOfType(Exception.class)
                 .isThrownBy( () -> {
                     mvc.perform(get("/api/exception").contentType(MediaType.APPLICATION_JSON));
                 })
                 .havingCause()
                 .withMessage("Generic exception");
    }

    @Test
    void itShouldGetRecipientNotFoundException() throws Exception {
        mvc.perform(get("/api/recipient/4500").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect( result -> {
                    assertThat(result.getResolvedException())
                            .isNotNull()
                            .isInstanceOf(RecipientNotFoundException.class)
                            ;
                } )
        ;
        mvc.perform(get("/api/recipient/-15").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect( result -> {
                    assertThat(result.getResolvedException())
                            .isNotNull()
                            .isInstanceOf(RecipientNotFoundException.class)
                    ;
                } )
        ;
    }

    @Test
    void recipientMethodArgumentTypeMismatchException() throws Exception {
        mvc.perform(get("/api/recipient/zdsgfdhjd").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect( result -> {
                    assertThat(result.getResolvedException())
                            .isNotNull()
                            .isInstanceOf(MethodArgumentTypeMismatchException.class)
                    ;
                } )
        ;
    }
}
