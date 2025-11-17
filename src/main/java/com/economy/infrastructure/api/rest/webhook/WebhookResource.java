package com.economy.infrastructure.api.rest.webhook;

import com.economy.interfaces.webhook.WebhookController;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/webhooks/mp")
public class WebhookResource {

    private final WebhookController webhookController;

    public WebhookResource(WebhookController webhookController) {
        this.webhookController = webhookController;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response receive(Map<String, Object> payload) throws MPException, MPApiException {
        return webhookController.receive(payload);
    }
}
