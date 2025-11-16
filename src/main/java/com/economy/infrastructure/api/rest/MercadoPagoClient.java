package com.economy.infrastructure.api.rest;

import com.economy.dto.output.QrCodePixParaPagamento;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.POST;

import java.util.Map;

@RegisterRestClient(configKey = "mercadopago-api")
public interface MercadoPagoClient {

        @POST
        @Path("/v1/pagamentos")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception;

        @POST
        @Path("/v1/payouts")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        Map<String, Object> createPayout(Map<String, Object> payload);

}
