package com.lojavirtual.loja_virtual;

public class ExcecaoApi extends Exception {

    private static final long serialVersionUID = 1L;

    public ExcecaoApi(String msgErro) {
        super(msgErro);
    }
}
