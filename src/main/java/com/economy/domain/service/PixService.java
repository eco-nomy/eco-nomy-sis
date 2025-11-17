package com.economy.domain.service;

import com.economy.domain.model.SaquePix;
import com.economy.dto.output.QrCodePixParaPagamento;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.Map;

public interface PixService {
    public QrCodePixParaPagamento criarPixQRCode(Long corpId, BigDecimal amount, String email, String firstName, String cnpj) throws Exception;
    public Map<String, Object> enviarPixPagamento(String pixKey, BigDecimal amount);
    public SaquePix criarRelatorioSaque(Long userId, String pixKey, BigDecimal amount);
}
