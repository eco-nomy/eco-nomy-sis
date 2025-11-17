package com.economy.interfaces;

import com.economy.dto.output.QrCodePixParaPagamento;

import java.util.Map;

public interface MercadoPagoController {
    public QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception;

    public Map<String, Object> createPayout(Map<String, Object> payload);
}
