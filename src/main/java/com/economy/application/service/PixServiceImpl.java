package com.economy.application.service;

import com.economy.domain.model.SaquePix;
import com.economy.domain.service.CarteiraService;
import com.economy.domain.service.PixService;
import com.economy.dto.output.QrCodePixParaPagamento;
import com.economy.infrastructure.api.restclient.MercadoPagoClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.Map;

@ApplicationScoped
public class PixServiceImpl implements PixService {

    @Inject
    @RestClient
    MercadoPagoClient mercadoPagoClient;

    @Inject
    CarteiraService carteiraService;
    //TODO: Aprender e aplicar o uso da api do MercadoPago

    @Override
    public QrCodePixParaPagamento criarPixQRCode(Long corpId, BigDecimal amount) throws Exception {
        // Example: create a payment preference for corporation to pay into platform
        // See Mercado Pago "Create a payment" / "Create a QR Code" endpoints for exact payload
        Map<String, Object> payload = Map.of(
                "transaction_amount", amount,
                "description", "Corp top-up",
                "payment_method_id", "pix"// simplified
        );
        QrCodePixParaPagamento qrCodePixParaPagamento= mercadoPagoClient.createPagamento(payload);
        return qrCodePixParaPagamento;
    }

    @Override
    public Map<String, Object> enviarPixPagamento(String pixKey, BigDecimal amount) {
        // Mercado Pago has endpoints for payouts/collections depending on account
        Map<String, Object> payload = Map.of(
                "amount", amount,
                "description", "User withdrawal",
                "additional_info", Map.of("pix", pixKey)
        );
        return mercadoPagoClient.createPayout(payload);
    }

    @Override
    public SaquePix criarRelatorioSaque(Long userId, String chavePix, BigDecimal quantia) {
        SaquePix w = new SaquePix();
        w.userId = userId;
        w.chavePix = chavePix;
        w.quantia = quantia;
        w.status = "PENDING";
        w.persist();
        return w;
    }
}
