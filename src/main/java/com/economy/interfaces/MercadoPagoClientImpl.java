package com.economy.interfaces;

import com.economy.domain.service.MercadoPagoService;
import com.economy.dto.output.QrCodePixParaPagamento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Map;

@ApplicationScoped
public class MercadoPagoClientImpl implements MercadoPagoController {

    @Inject
    private MercadoPagoService mercadoPagoService;

    @Override
    public QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception {
        return mercadoPagoService.createPagamento(payload);
    }

    @Override
    public Map<String, Object> createPayout(Map<String, Object> payload) {
        return mercadoPagoService.createPayout(payload);
    }
}
