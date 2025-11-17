package com.economy.domain.service;

import com.economy.dto.output.QrCodePixParaPagamento;

import java.util.Map;

public interface MercadoPagoService {
    QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception;
    Map<String, Object> createPayout(Map<String, Object> payload);
}
