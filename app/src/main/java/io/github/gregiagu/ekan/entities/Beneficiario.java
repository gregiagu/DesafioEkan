package io.github.gregiagu.ekan.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
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

    public Beneficiario(Beneficiario target) {
        this.id = target.id;
        this.nome = target.nome;
        this.telefone = target.telefone;
        this.dataNascimento = target.dataNascimento;
        this.dataInclusao = target.dataInclusao;
        this.dataAtualizacao = target.dataAtualizacao;
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
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataInclusao=" + dataInclusao +
                ", dataAtualizacao=" + dataAtualizacao +
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
}
