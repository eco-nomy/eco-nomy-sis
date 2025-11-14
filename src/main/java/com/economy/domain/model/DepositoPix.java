package com.economy.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class DepositoPix extends PanacheEntity {
    public Long corporationId;
    public BigDecimal quantia;
    public String status; // PENDING, CONFIRMED
    public String mpPagamentoId; // marketplace/gateway id
    public LocalDateTime dataCriacao = LocalDateTime.now();
}
