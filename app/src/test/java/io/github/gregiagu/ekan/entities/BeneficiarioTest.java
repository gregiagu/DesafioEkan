package io.github.gregiagu.ekan.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BeneficiarioTest {

    @Test
    void itShouldCreateEmptyBeneficiario() {
        Beneficiario beneficiario = new Beneficiario();
        assertThat(beneficiario)
                .isNotNull()
                .isInstanceOf(Beneficiario.class)
                ;
    }

    @Test
    void itShouldCopyBeneficiario() {
        Beneficiario original = new Beneficiario(
                "Beneficiario",
                "+55 (11) 999.888.777",
                "1971-10-10",
                "1999-11-13",
                "2011-08-17"
        );

        Beneficiario copy = new Beneficiario(original);

        assertThat(original.hashCode())
                .isEqualTo(copy.hashCode())
                ;
    }
}
