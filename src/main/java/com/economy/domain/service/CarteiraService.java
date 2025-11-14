package com.economy.domain.service;

import com.economy.domain.model.ContaCorporativa;
import com.economy.domain.model.ContaUsuario;

import java.math.BigDecimal;

public interface CarteiraService {
    public ContaCorporativa findCorporacao(Long id);
    public ContaUsuario findUser(Long id);
    public void creditCorporacao(Long corpId, BigDecimal amount);
    public void internalTransfer(Long corpId, Long userId, BigDecimal amount);
    }