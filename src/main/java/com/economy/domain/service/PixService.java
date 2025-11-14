package com.economy.domain.service;

import com.economy.domain.model.SaldarPix;
import com.economy.domain.model.SaquePix;

import java.math.BigDecimal;
import java.util.Map;

public interface PixService {
    public Map<String, Object> criarPixQRCode(Long corpId, BigDecimal amount);
    public Map<String, Object> enviarPixPagamento(String pixKey, BigDecimal amount);
    public SaquePix criarRelatorioSaque(Long userId, String pixKey, BigDecimal amount);
}
