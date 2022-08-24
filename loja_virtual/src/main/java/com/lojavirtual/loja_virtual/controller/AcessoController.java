package com.lojavirtual.loja_virtual.controller;

import com.lojavirtual.loja_virtual.model.Acesso;
import com.lojavirtual.loja_virtual.repository.AcessoRepository;
import com.lojavirtual.loja_virtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class AcessoController {


    @Autowired
    private AcessoService acessoService;

    @Autowired
    private AcessoRepository acessoRepository;

    @ResponseBody //~>para dar o retorno da api
    @PostMapping(value = "**/salvarAcesso") /*Mapeando a url para receber JSON*/
    public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) { /*Recebe o JSON e converte pra Objeto*/
        Acesso acessoSalvo = new Acesso();
        acessoSalvo = acessoService.salvar(acesso);

        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "**/deleteAcesso")
    public ResponseEntity<?> delete(@RequestBody Acesso acesso) {
        acessoRepository.deleteById(acesso.getId());

        return new ResponseEntity("Acesso removido", HttpStatus.OK);
    }

    //@Secured({ "ROLE_GERENTE", "ROLE_ADMIN" })
    @ResponseBody
    @DeleteMapping(value = "**/deleteAcessoPorId/{id}")
    public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id) {
        acessoRepository.deleteById(id);

        return new ResponseEntity<>("Acesso removido", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "**/obterAcesso/{id}")
    public ResponseEntity<Acesso> obterAcesso(@PathVariable("id") Long id) {
        Acesso acesso = acessoRepository.findById(id).get();

        return new ResponseEntity<>(acesso, HttpStatus.OK);
    }


}
