package io.github.gregiagu.ekan.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class RecipientTest {

    @Test
    void buildNewRecipient() {
        Recipient hap = Recipient
                .builder()
                .fullName("Herberson Aloísio Pereira")
                .telephoneNumber("+5598977545652")
                .birthdate(LocalDate.parse("1979-10-11"))
                .registerDate(LocalDate.parse("2004-08-17"))
                .lastUpdate(LocalDate.parse("2010-04-06"))
                .build();

        assertThat(hap)
                .isNotNull()
                .isInstanceOf(Recipient.class)
                ;
    }
}
