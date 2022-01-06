package com.lojavirtual.loja_virtual.enums;

import lombok.Data;

public enum TipoEndereco {

    COBRANCA("Cobranca"),
    ENTREGA("Entrega");

    private String descricao;

    TipoEndereco(String descricao) {
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
