package com.economy.interfaces;

import com.economy.domain.model.Pagamento;
import com.economy.domain.service.PagamentoService;
import com.economy.dto.input.PagamentoRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PagamentoControllerImpl implements PagamentoController{
    @Inject
    PagamentoService pagamentoService;

    public Pagamento pagar(PagamentoRequest pagamentoRequest){
        return pagamentoService.makeInternalPayment(pagamentoRequest);
    }
}
