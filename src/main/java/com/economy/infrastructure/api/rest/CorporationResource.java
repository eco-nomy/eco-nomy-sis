package com.economy.infrastructure.api.rest;

import com.economy.domain.service.CarteiraService;
import com.economy.domain.service.PixService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.Map;

//TODO: Refatorar posicao no projeto
@Path("/corporations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    @Inject
    PixService pixService;

    @Inject
    CarteiraService carteiraService;

    @POST
    public void createCorp( Map<String, String> body){
        //TODO: Lembrar de implementar a criacao de corporacao
    }

    @POST
    @Path("/{id}/create-pix-qr")
    public Map<String, Object> createPixQr(@PathParam("id") Long id,
                                           Map<String, Object> body) {
        BigDecimal amount = new BigDecimal(body.get("amount").toString());
        return pixService.criarPixQRCode(id, amount);
    }

}
