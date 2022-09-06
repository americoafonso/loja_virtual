package com.lojavirtual.loja_virtual.repository;

import com.lojavirtual.loja_virtual.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    @Query("SELECT a FROM Acesso a WHERE UPPER(TRIM(a.descricao)) LIKE %?1%")
    List<Acesso> buscarAcessoDesc(String desc);

}
