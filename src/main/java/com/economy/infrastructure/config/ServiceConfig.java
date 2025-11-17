package com.economy.infrastructure.config;

import fiap.sprint.application.*;
import fiap.sprint.domain.repository.AcessoRepository;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.domain.service.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceConfig {

    @ApplicationScoped
    public AcessoService acessoService(AcessoRepository acessoRepository) {
        return new AcessoServiceImpl(acessoRepository);
    }

    @ApplicationScoped
    public AgendamentoService agendamentoService(AgendamentoRepository agendamentoRepository) {
        return new AgendamentoServiceImpl(agendamentoRepository);
    }

    @ApplicationScoped
    public PerguntaService perguntaService(PerguntaRepository perguntaRepository) {
        return new PerguntaServiceImpl(perguntaRepository);
    }

    @ApplicationScoped
    public UsuarioService usuarioService(UsuarioRepository usuarioRepository, AgendamentoRepository agendamentoRepository,
                                         PerguntaRepository perguntaRepository,  AcessoRepository acessoRepository) {
        return new UsuarioServiceImpl(usuarioRepository,  perguntaRepository, agendamentoRepository, acessoRepository);
    }
}
