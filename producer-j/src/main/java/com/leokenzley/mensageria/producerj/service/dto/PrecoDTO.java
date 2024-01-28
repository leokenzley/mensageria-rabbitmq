package com.leokenzley.mensageria.producerj.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PrecoDTO implements Serializable {
    @JsonProperty("codigoProduto")
    private String codigoProduto;
    @JsonProperty("quantidadeProduto")
    private Integer quantidadeProduto;
}
