package com.economy.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ContaUsuario extends PanacheEntity {
  public String nome;
  public String chavePix;
  public BigDecimal balance = BigDecimal.ZERO;
}
