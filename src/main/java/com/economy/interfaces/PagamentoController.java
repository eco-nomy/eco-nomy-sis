package com.economy.interfaces;

import com.economy.domain.model.Pagamento;
import com.economy.dto.input.PagamentoRequest;

public interface PagamentoController {
    public Pagamento pagar(PagamentoRequest pagamentoRequest);
}
