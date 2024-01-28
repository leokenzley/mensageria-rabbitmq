package com.leokenzley.mensageria.producerj.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrecoDTO implements Serializable {
    private String codigoProduto;
    private Integer quantidadeProduto;
}
