package com.fiap.banksecure.app.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TipoSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String coberturaMinima;

    private BigDecimal valorPremioBase;

    public TipoSeguro() {
    }

    public TipoSeguro(Long id, String titulo, String coberturaMinima, BigDecimal valorPremioBase) {
        this.id = id;
        this.titulo = titulo;
        this.coberturaMinima = coberturaMinima;
        this.valorPremioBase = valorPremioBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCoberturaMinima() {
        return coberturaMinima;
    }

    public void setCoberturaMinima(String coberturaMinima) {
        this.coberturaMinima = coberturaMinima;
    }

    public BigDecimal getValorPremioBase() {
        return valorPremioBase;
    }

    public void setValorPremioBase(BigDecimal valorPremioBase) {
        this.valorPremioBase = valorPremioBase;
    }
}
