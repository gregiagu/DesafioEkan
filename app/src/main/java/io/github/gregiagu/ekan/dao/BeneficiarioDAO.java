package io.github.gregiagu.ekan.dao;

import io.github.gregiagu.ekan.entities.Beneficiario;

import java.util.List;

public interface BeneficiarioDAO {

    Beneficiario findById(Integer id);

    List<Beneficiario> findAllBeneficiarios();
}
