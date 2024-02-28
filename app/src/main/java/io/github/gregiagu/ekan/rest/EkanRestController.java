package io.github.gregiagu.ekan.rest;

import io.github.gregiagu.ekan.dao.BeneficiarioDAO;
import io.github.gregiagu.ekan.entities.Beneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EkanRestController {

    private BeneficiarioDAO beneficiarioDAO;

    @Autowired
    public EkanRestController(BeneficiarioDAO beneficiarioDAO) {
        this.beneficiarioDAO = beneficiarioDAO;
    }

    @GetMapping("/health")
    public String getHealth() {
        return LocalDateTime
                .now()
                .toString()
                ;
    }

    @GetMapping("/beneficiarios")
    public List<Beneficiario> getRecipients() {
        return beneficiarioDAO.findAllBeneficiarios();
    }
}
