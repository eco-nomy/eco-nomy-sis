package com.economy.infrastructure.api.rest;

import com.economy.domain.model.ContaUsuario;
import com.economy.domain.model.SaquePix;
import com.economy.domain.service.CarteiraService;
import com.economy.domain.service.PixService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

//TODO: refatorar e colocar tudo sob o nome de restController
@Path("/sacar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SacarResource {

    @Inject
    PixService pixService;

    @Inject
    CarteiraService carteiraService;

    @POST
    public SaquePix sacar(SaquePix saquePix){
        ContaUsuario contaUsuario = carteiraService.findUser(saquePix.userId);
        if (contaUsuario == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        if (contaUsuario.balance.compareTo(saquePix.quantia) < 0) throw new
                WebApplicationException("Saldo insuficiente", 400);

        contaUsuario.balance =  contaUsuario.balance.subtract(saquePix.quantia);
        contaUsuario.persist();

        SaquePix relatorioSaque = pixService.criarRelatorioSaque(saquePix.userId, saquePix.chavePix,
                saquePix.quantia);

        Map<String, Object> mercadoPagoResponse = pixService.enviarPixPagamento(saquePix.chavePix, saquePix.quantia);

        relatorioSaque.mpOperationId = mercadoPagoResponse.getOrDefault("id", "").toString();
        relatorioSaque.status = "SENT";
        relatorioSaque.persist();

        return relatorioSaque;
    }
}
