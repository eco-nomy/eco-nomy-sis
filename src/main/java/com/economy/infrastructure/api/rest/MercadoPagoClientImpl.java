package com.economy.infrastructure.api.rest;

import com.economy.dto.output.QrCodePixParaPagamento;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.resources.payment.Payment;
import jakarta.ws.rs.core.Response;
import lombok.Value;
import org.eclipse.microprofile.config.ConfigProvider;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MercadoPagoClientImpl implements MercadoPagoClient{

    private String mercadoPagoToken = ConfigProvider.getConfig().getValue("mercadopago.token", String.class);

    @Override
    public QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception {

        try{
            MercadoPagoConfig.setAccessToken(mercadoPagoToken);

            Map<String, String> customHeaders = new HashMap<>();
            customHeaders.put("x-idempotency-key", UUID.randomUUID().toString());

            MPRequestOptions requestOptions = MPRequestOptions.builder()
                    .customHeaders(customHeaders)
                    .build();

            PaymentClient paymentClient = new PaymentClient();

            PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
                    .transactionAmount((BigDecimal) payload.get("transaction_amount"))
                    .description(payload.get("description").toString())
                    .paymentMethodId("pix")
                    .dateOfExpiration(OffsetDateTime.now().plusHours(24))
                    .payer(
                            PaymentPayerRequest.builder()
                                    .email(payload.get("email").toString())
                                    .firstName(payload.get("first_name").toString())
                                    .identification(IdentificationRequest.builder()
                                            .type("CNPJ")
                                            .number(payload.get("number").toString())
                                            .build())
                                    .build())
                                    .build();
            Payment payment = paymentClient.create(paymentCreateRequest, requestOptions);
            QrCodePixParaPagamento qrCodePixParaPagamento= new QrCodePixParaPagamento(
                    payment.getId(),
                    payment.getStatus(),
                    payment.getPointOfInteraction().getTransactionData().getQrCode(),
                    payment.getPointOfInteraction().getTransactionData().getQrCodeBase64()
            );

            return qrCodePixParaPagamento;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Map<String, Object> createPayout(Map<String, Object> payload) {
        return Map.of();
    }
}
