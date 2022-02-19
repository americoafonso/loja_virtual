package com.lojavirtual.loja_virtual;

import com.lojavirtual.loja_virtual.controller.AcessoController;
import com.lojavirtual.loja_virtual.model.Acesso;
import com.lojavirtual.loja_virtual.repository.AcessoRepository;
import com.lojavirtual.loja_virtual.service.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualApplication.class)
public class LojaVirtualApplicationTests extends TestCase {

	@Autowired
	private AcessoController acessoController;

	@Test
	public void testCadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		acesso = acessoController.salvar(acesso).getBody();

		assert acesso != null;
		Assertions.assertNotNull(acesso.getId());
	}

}
