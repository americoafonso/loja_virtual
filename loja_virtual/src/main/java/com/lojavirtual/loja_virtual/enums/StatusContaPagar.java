package com.lojavirtual.loja_virtual.enums;

public enum StatusContaPagar {

    COBRANCA("paga"),
    VENCIDA("vencida"),
    ABERTA("aberta"),
    QUITADA("quitada"),
    FUNCIONARIO("funcionario"),
    RENOGOCIADA("renegociada");

    private String descricao;

    StatusContaPagar(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
