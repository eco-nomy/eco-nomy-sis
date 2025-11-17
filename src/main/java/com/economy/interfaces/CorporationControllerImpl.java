package com.economy.interfaces;

import com.economy.domain.service.CarteiraService;
import com.economy.domain.service.PixService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.Map;

public class CorporationControllerImpl implements CorporationController{

    @Inject
    PixService pixService;

    @Inject
    CarteiraService carteiraService;

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
