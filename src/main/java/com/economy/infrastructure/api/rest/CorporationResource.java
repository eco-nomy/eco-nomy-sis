package com.economy.infrastructure.api.rest;

import com.economy.interfaces.CorporationController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/corporations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    private final CorporationController corporationController;

    public CorporationResource(CorporationController corporationController) {
        this.corporationController = corporationController;
    }

    @POST
    public void createCorp( Map<String, String> body){
        corporationController.createCorp( body);
    }

    @POST
    @Path("/{id}/create-pix-qr")
    public Response createPixQr(@PathParam("id") Long corpId,
                                              Map<String, Object> body) throws Exception {


        return corporationController.createPixQr(corpId, body);
    }

}
