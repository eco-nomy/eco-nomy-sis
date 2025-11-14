package com.economy.dto.input;

import java.math.BigDecimal;

public class PagamentoRequest {
    public Long origemCorporationId;
    public Long destinoUserId;
    public BigDecimal quantia;
}
