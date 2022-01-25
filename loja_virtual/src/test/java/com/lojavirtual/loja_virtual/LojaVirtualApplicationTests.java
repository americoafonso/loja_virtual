package com.lojavirtual.loja_virtual;

import com.lojavirtual.loja_virtual.model.Acesso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repository.AcessoRepository;
import service.AcessoService;

@SpringBootTest(classes = LojaVirtualApplication.class)
class LojaVirtualApplicationTests {

	@Autowired
	private AcessoService acessoService;
	
	@Autowired
	private AcessoRepository acessoRepository;

	@Test
	public void testCadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");

		acessoRepository.save(acesso);
	}

	@Test
	void contextLoads() {
	}

}
