package com.lojavirtual.loja_virtual.enums;

public enum StatusContaReceber {

    COBRANCA("paga"),
    VENCIDA("vencida"),
    ABERTA("aberta"),
    QUITADA("quitada");

    private String descricao;

    StatusContaReceber(String descricao) {
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
