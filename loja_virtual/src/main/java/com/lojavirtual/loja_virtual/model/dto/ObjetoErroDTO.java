package com.lojavirtual.loja_virtual.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ObjetoErroDTO implements Serializable {

    private String error;
    private String code;

}
