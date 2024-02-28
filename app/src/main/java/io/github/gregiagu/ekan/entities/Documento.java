package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    private String tipoDocumento;
    private String descricao;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;

    public Documento() {}

    public Documento(
            String tipoDocumento,
            String descricao,
            LocalDate dataInclusao,
            LocalDate dataAtualizacao
    ) {
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Documento(
            String tipoDocumento,
            String descricao,
            String dataInclusao,
            String dataAtualizacao
    ) {
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.dataInclusao = LocalDate.parse(dataInclusao);
        this.dataAtualizacao = LocalDate.parse(dataAtualizacao);
    }

    public Documento(Documento source) {
        this.beneficiario = source.beneficiario;
        this.tipoDocumento = source.tipoDocumento;
        this.dataInclusao = source.dataInclusao;
        this.dataAtualizacao = source.dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(tipoDocumento, documento.tipoDocumento) && Objects.equals(descricao, documento.descricao) && Objects.equals(dataInclusao, documento.dataInclusao) && Objects.equals(dataAtualizacao, documento.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, descricao, dataInclusao, dataAtualizacao);
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", beneficiario=" + beneficiario +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }

    public int getId() {
        return id;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
