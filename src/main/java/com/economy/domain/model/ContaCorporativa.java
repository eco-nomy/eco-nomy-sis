package com.economy.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ContaCorporativa extends PanacheEntity {
    public String nome;
    public BigDecimal balancaDisponivel = BigDecimal.ZERO;
    public BigDecimal reservado = BigDecimal.ZERO;
}
