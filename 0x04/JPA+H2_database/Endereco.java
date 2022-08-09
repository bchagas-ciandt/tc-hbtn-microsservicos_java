package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String endereco;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, String endereco, Integer numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco1 = (Endereco) o;
        return Objects.equals(getId(), endereco1.getId()) && Objects.equals(getEndereco(), endereco1.getEndereco()) && Objects.equals(getNumero(), endereco1.getNumero()) && Objects.equals(getBairro(), endereco1.getBairro()) && Objects.equals(getCidade(), endereco1.getCidade()) && Objects.equals(getEstado(), endereco1.getEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEndereco(), getNumero(), getBairro(), getCidade(), getEstado());
    }
}
