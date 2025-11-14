package com.economy.application.service;

import com.economy.domain.model.ContaCorporativa;
import com.economy.domain.model.ContaUsuario;
import com.economy.domain.service.CarteiraService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@ApplicationScoped
public class CarteiraServiceImpl implements CarteiraService {
    public ContaCorporativa findCorporacao(Long id) {
        return ContaCorporativa.findById(id);
    }

    public ContaUsuario findUser(Long id) {
        return ContaUsuario.findById(id);
    }

    @Transactional
    public void creditCorporacao(Long corpId, BigDecimal amount) {
        ContaCorporativa corp = findCorporacao(corpId);
        if (corp == null) throw new IllegalArgumentException("Corporação não  encontrada!");
        corp.balancaDisponivel = corp.balancaDisponivel.add(amount);
        corp.persist();
    }


    @Transactional
    public void internalTransfer(Long corpId, Long userId, BigDecimal amount) {
        ContaCorporativa corp = findCorporacao(corpId);
        ContaUsuario user = findUser(userId);
        if (corp == null || user == null) throw new IllegalArgumentException("Conta não encontrada");
        if (corp.balancaDisponivel.compareTo(amount) < 0) throw new IllegalArgumentException("Saldo insuficiente!");

        corp.balancaDisponivel = corp.balancaDisponivel.subtract(amount);
        user.balance = user.balance.add(amount);
        corp.persist();
        user.persist();
    }
}
