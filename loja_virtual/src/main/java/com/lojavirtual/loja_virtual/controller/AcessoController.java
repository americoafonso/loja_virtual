package com.lojavirtual.loja_virtual.controller;

import com.lojavirtual.loja_virtual.model.Acesso;
import com.lojavirtual.loja_virtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @ResponseBody
    @PostMapping(value = "**/salvarAcesso")
    public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.salvar(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }
}
