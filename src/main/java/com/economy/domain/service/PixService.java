package com.economy.domain.service;

import com.economy.domain.model.SaldarPix;

import java.math.BigDecimal;
import java.util.Map;

public interface PixService {
    public Map<String, Object> criarPixQRCode(Long corpId, BigDecimal amount);
    public Map<String, Object> enviarPixPagamento(String pixKey, BigDecimal amount);
    public SaldarPix criarRelatorioSaque(Long userId, String pixKey, BigDecimal amount);
}
