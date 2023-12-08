package com.lojavirtual.loja_virtual.repository;

import com.lojavirtual.loja_virtual.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    @Query("Select a From Acesso a Where Upper(Trim(a.descricao)) Like %?1%")
    List<Acesso> buscarAcessoDesc(String desc);
}
