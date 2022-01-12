package com.lojavirtual.loja_virtual.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "avaliacao_produto")
@SequenceGenerator(name = "seq_avaliacao_produto", sequenceName = "seq_avaliacao_produto", allocationSize = 1, initialValue = 1)
public class AvaliacaoProduto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avaliacao_produto")
    private long id;

    private Integer nota;

    private String descricao;

    @ManyToOne(targetEntity = Pessoa.class) // ~> targetEntity porque pessoa e class abstrata
    @JoinColumn(name = "pessoa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;
}
