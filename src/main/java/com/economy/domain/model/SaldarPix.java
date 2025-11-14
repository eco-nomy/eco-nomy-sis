package com.economy.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PixWithdrawal extends PanacheEntity {
    public Long userId;
    public BigDecimal quantidade;
    public String chavePix;
    public String status; // PENDING, SENT, FAILED
    public String mpOperationId;
    public LocalDateTime dataCriacao = LocalDateTime.now();
}
