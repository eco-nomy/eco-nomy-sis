package com.economy.interfaces.webhook;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import jakarta.ws.rs.core.Response;

import java.util.Map;

public interface WebhookController {
    public Response receive(Map<String, Object> payload) throws MPException, MPApiException;
}
