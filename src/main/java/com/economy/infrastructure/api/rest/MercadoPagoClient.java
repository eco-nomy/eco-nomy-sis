package com.economy.infrastructure.api.rest;

import com.economy.dto.output.QrCodePixParaPagamento;
import com.economy.interfaces.MercadoPagoClientImpl;
import com.economy.interfaces.MercadoPagoController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.POST;

import java.util.Map;

@RegisterRestClient(configKey = "mercadopago-api")
public class MercadoPagoClient {
        private final MercadoPagoController mercadoPagoController;

    public MercadoPagoClient(MercadoPagoController mercadoPagoController) {
        this.mercadoPagoController = mercadoPagoController;
    }

        @POST
        @Path("/v1/pagamentos")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public QrCodePixParaPagamento createPagamento(Map<String, Object> payload) throws Exception{
                return mercadoPagoController.createPagamento(payload);
        }

        @POST
        @Path("/v1/payouts")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Map<String, Object> createPayout(Map<String, Object> payload){
                return mercadoPagoController.createPayout(payload);
        }

}
