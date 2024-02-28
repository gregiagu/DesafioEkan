package io.github.gregiagu.ekan.dao;

import io.github.gregiagu.ekan.entities.Beneficiario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeneficiarioDAOImpl implements BeneficiarioDAO{

    private EntityManager entityManager;

    @Autowired
    public BeneficiarioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Beneficiario findById(Integer id) {
        return entityManager.find(Beneficiario.class, id);
    }

    @Override
    public List<Beneficiario> findAllBeneficiarios() {
        TypedQuery<Beneficiario> fromBeneficiarios = entityManager.createQuery("FROM Beneficiario", Beneficiario.class);
        return fromBeneficiarios.getResultList();
    }
}
