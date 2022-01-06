package com.lojavirtual.loja_virtual.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private long id;

    private String tipoUnidade;

    private String nome;

    private Boolean ativo = Boolean.TRUE;

    @Column(columnDefinition = "text", length = 2000)
    private String descricao;

    /** TODO Nota item produto ASSOCIAR**/

    private Double peso;

    private Double altura;

    private Double profundidade;

    private BigDecimal valorVenda = BigDecimal.ZERO;

    private Integer QtdadeEstoque = 0;

    private Integer QtdadeAlertaEstoque = 0;

    private String linkYoutube;

    private Boolean alertaQtdadeEstoque = Boolean.FALSE;

    private Integer qtdadeClique = 0;
}
