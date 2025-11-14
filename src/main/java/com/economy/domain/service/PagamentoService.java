package com.economy.domain.service;

import com.economy.domain.model.Pagamento;
import com.economy.dto.input.PagamentoRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PagamentoService {

    @Inject
    CarteiraService carteiraService;

    @Transactional
    public Pagamento makeInternalPayment(PagamentoRequest request) {
        // create record
        Pagamento p = new Pagamento();
        p.corporacaoId = request.origemCorporationId;
        p.userId = request.destinoUserId;
        p.quantia = request.quantia;
        p.status = "PENDING";
        p.persist();

        // business logic: transfer
        carteiraService.internalTransfer(request.origemCorporationId, request.destinoUserId, request.quantia);

        p.status = "COMPLETED";
        p.persist();
        return p;
    }
}