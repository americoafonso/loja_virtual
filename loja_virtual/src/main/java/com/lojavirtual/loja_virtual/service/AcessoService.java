package com.lojavirtual.loja_virtual.service;

import com.lojavirtual.loja_virtual.model.Acesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lojavirtual.loja_virtual.repository.AcessoRepository;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    public Acesso salvar(Acesso acesso) {
        return acessoRepository.save(acesso);
    }
}
