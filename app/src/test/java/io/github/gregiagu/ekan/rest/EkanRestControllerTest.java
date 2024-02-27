package io.github.gregiagu.ekan.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
public class EkanRestControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void itShouldGetTargetUrl() throws Exception {
        String timestamp = this.mvc.perform(
                        MockMvcRequestBuilders.get("/api/health")
                                .contentType(MediaType.TEXT_PLAIN)
                )
                .andReturn()
                .getResponse()
                .getContentAsString();
        LocalDateTime localDateTime = LocalDateTime.parse(timestamp);
        assertThat(localDateTime)
                .isInstanceOf(LocalDateTime.class);
    }

    @Test
    void itShouldGetaRecipient() throws Exception {
        String plainJson = mvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/recipients")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(plainJson);
    }
}
