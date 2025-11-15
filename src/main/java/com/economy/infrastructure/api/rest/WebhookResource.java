package com.economy.infrastructure.api.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/webhooks/mp")
public class WebhookResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response receive(Map<String, Object> payload) {
        // Implement verification using mp.webhook.secret if configured
        // Parse event type and update PixDeposit / PixWithdrawal accordingly
        System.out.println("Received webhook: " + payload);
        return Response.ok().build();
    }

}
