package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ddd;
    private Integer numero;

    public Telefone() {
    }

    public Telefone(Long id, Integer ddd, Integer numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", ddd=" + ddd +
                ", numero=" + numero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(getId(), telefone.getId()) && Objects.equals(getDdd(), telefone.getDdd()) && Objects.equals(getNumero(), telefone.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDdd(), getNumero());
    }
}
