package io.github.gregiagu.ekan.entities;

import io.github.gregiagu.ekan.dao.BeneficiarioDAO;
import io.github.gregiagu.ekan.dao.BeneficiarioDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

public class BeneficiarioTest {

    @Autowired
    BeneficiarioDAO beneficiarioDAO;

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
