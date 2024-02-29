package io.github.gregiagu.ekan.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class EntitiesTest {

    @Test
    void itShouldCopyEntity() {
        Recipient first = new Recipient(
                "First Recipient",
                "+5511964442320",
                "2010-05-13",
                "2013-05-13",
                "2021-09-12"
        );

        Recipient second = new Recipient(first);

        assertThat(first.hashCode())
                .isNotEqualTo(second.hashCode())
                ;
    }

}
