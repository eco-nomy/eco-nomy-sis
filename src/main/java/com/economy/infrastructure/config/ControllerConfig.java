package com.economy.infrastructure.config;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.service.AcessoService;
import fiap.sprint.domain.service.AgendamentoService;
import fiap.sprint.domain.service.PerguntaService;
import fiap.sprint.domain.service.UsuarioService;
import fiap.sprint.interfaces.*;
import jakarta.enterprise.context.ApplicationScoped;

public class ControllerConfig {

    @ApplicationScoped
    public AcessoController acessoController(AcessoService acessoService) {
        return new AcessoControllerImpl(acessoService);
    }

    @ApplicationScoped
    public AgendamentoController agendamentoController(AgendamentoService agendamentoService) {
        return new AgendamentoControllerImpl(agendamentoService);
    }

    @ApplicationScoped
    public PerguntaController perguntaController(PerguntaService perguntaService,  UsuarioService usuarioService) {
        return new PerguntaControllerImpl(perguntaService, usuarioService);
    }

    @ApplicationScoped
    public UsuarioController usuarioController(UsuarioService usuarioService) {
        return new UsuarioControllerImpl(usuarioService);
    }
}
