package com.economy.infrastructure.api.rest;

import com.economy.domain.model.ContaUsuario;
import com.economy.domain.model.SaquePix;
import com.economy.domain.service.CarteiraService;
import com.economy.domain.service.PixService;
import com.economy.interfaces.SacarController;
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

    private final SacarController sacarController;

    public SacarResource(SacarController sacarController) {
        this.sacarController = sacarController;
    }

    @POST
    public SaquePix sacar(SaquePix saquePix){
        return sacarController.sacar(saquePix);
    }
}
