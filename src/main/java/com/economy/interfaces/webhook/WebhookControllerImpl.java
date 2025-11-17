package com.economy.interfaces.webhook;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import jakarta.ws.rs.core.Response;

import java.util.Map;

public class WebhookControllerImpl implements WebhookController{
    public Response receive(Map<String, Object> payload) throws MPException, MPApiException {
        // Implement verification using mp.webhook.secret if configured
        // Parse event type and update PixDeposit / PixWithdrawal accordingly
        System.out.println("Received webhook: " + payload);


        Map<String, Object> data = (Map<String, Object>) payload.get("data");
        String paymentId = data.get("id").toString();

        //Aqui o mercado pago espera que seja respondido rapidamente, entao uma chamada assincrona seria mais apropriada
        //entretanto o codigo ficaria meio estranho, vou mudar se for necessario.......
        processPaymentUpdate(paymentId);

        return Response.ok().build();
    }

    //    TODO mover para uma classe de service
    private void processPaymentUpdate(String paymentId) throws MPException, MPApiException {
        PaymentClient paymentClient = new PaymentClient();
        Payment payment = paymentClient.get(Long.parseLong(paymentId));
        String status = payment.getStatus();
        if (status.equals("approved")) {
            //
            // paymentRepository.markAsPaid(paymentId);
        }
    }
}
