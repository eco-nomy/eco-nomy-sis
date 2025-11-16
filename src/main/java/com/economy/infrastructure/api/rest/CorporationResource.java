package com.economy.infrastructure.api.rest;

import com.economy.domain.service.CarteiraService;
import com.economy.domain.service.PixService;
import com.economy.dto.output.QrCodePixParaPagamento;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    public Response createPixQr(@PathParam("id") Long corpId,
                                              Map<String, Object> body) throws Exception {
        BigDecimal amount = new BigDecimal(body.get("quantia").toString());
        return Response.ok(pixService.criarPixQRCode(corpId, amount)).build();
    }

}
