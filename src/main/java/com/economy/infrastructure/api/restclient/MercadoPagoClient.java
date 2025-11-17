package com.economy.infrastructure.api.restclient;

import com.economy.dto.output.QrCodePixParaPagamento;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.*;

import java.util.Map;

@Path("/")
@RegisterRestClient(configKey = "mercadopago-api")
public interface MercadoPagoClient {

    @POST
    @Path("/v1/pagamentos")
    QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception;

    @POST
    @Path("/v1/payouts")
    Map<String, Object> createPayout(Map<String, Object> payload);
}
