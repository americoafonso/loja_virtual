package com.lojavirtual.loja_virtual.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "nota_fiscal_compra")
@SequenceGenerator(name = "seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
    private long id;

    private String numeroNota;

    private String serieNota;

    private String descricaoObs;

    private BigDecimal valorTotal;

    private BigDecimal valorDesconto;

    private BigDecimal valorIcms;

    @Temporal(TemporalType.DATE)
    private Date dataCompra;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "conta_pagar_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
    private ContaPagar contaPagar;
}
