package com.economy.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PagamentoInterno extends PanacheEntity {
    public Long corporacaoId;
    public Long userId;
    public BigDecimal quantidade;
    public String status; // PENDING, COMPLETED, FAILED
    public LocalDateTime dataCriacao = LocalDateTime.now();
}
