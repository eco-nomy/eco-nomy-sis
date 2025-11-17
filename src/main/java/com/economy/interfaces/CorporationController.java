package com.economy.interfaces;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.Map;

public interface CorporationController {
    public void createCorp( Map<String, String> body);
    public Response createPixQr(@PathParam("id") Long corpId,
                                Map<String, Object> body) throws Exception;
}
