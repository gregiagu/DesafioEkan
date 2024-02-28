package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;

import javax.print.Doc;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "beneficiarios")
public class Beneficiario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario")
    private List<Documento> documentos;

    public Beneficiario() {
    }

    public Beneficiario(
            String nome,
            String telefone,
            LocalDate dataNascimento,
            LocalDate dataInclusao,
            LocalDate dataAtualizacao
    ) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Beneficiario(
            String nome,
            String telefone,
            String dataNascimento,
            String dataInclusao,
            String dataAtualizacao
    ) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.dataInclusao = LocalDate.parse(dataInclusao);
        this.dataAtualizacao = LocalDate.parse(dataAtualizacao);
    }

    public Beneficiario(Beneficiario source) {
        this.nome = source.nome;
        this.telefone = source.telefone;
        this.dataNascimento = source.dataNascimento;
        this.dataInclusao = source.dataInclusao;
        this.dataAtualizacao = source.dataAtualizacao;
        this.documentos = source.documentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiario that = (Beneficiario) o;
        return Objects.equals(nome, that.nome) && Objects.equals(telefone, that.telefone) && Objects.equals(dataNascimento, that.dataNascimento) && Objects.equals(dataInclusao, that.dataInclusao) && Objects.equals(dataAtualizacao, that.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, dataNascimento, dataInclusao, dataAtualizacao);
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataInclusao=" + dataInclusao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", documentos=" + documentos +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public void addDocumento(Documento doc) {
        if (documentos == null) {
            documentos = new ArrayList<>();
        }
        documentos.add(doc);
    }
}
