package com.lojavirtual.loja_virtual;

import com.lojavirtual.loja_virtual.controller.AcessoController;
import com.lojavirtual.loja_virtual.model.Acesso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualApplication.class)
public class LojaVirtualApplicationTests {

	@Autowired
	private AcessoController acessoController;

	@Test
	public void testCadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");

		acessoController.salvar(acesso);
	}

}
