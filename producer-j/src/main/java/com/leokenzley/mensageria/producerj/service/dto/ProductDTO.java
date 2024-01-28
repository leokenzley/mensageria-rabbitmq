package com.leokenzley.mensageria.producerj.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("productAmount")
    private Integer productAmount;
}
