package com.economy.domain.service;

import com.economy.domain.model.Pagamento;
import com.economy.dto.input.PagamentoRequest;


public interface PagamentoService {
    public Pagamento makeInternalPayment(PagamentoRequest request);
}