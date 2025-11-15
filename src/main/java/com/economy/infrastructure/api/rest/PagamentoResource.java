package com.economy.infrastructure.api.rest;

import com.economy.domain.model.Pagamento;
import com.economy.domain.service.PagamentoService;
import com.economy.dto.input.PagamentoRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/payments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @Inject
    PagamentoService pagamentoService;

    @POST
    public Pagamento pagar(PagamentoRequest pagamentoRequest){
        return pagamentoService.makeInternalPayment(pagamentoRequest);
    }
}
