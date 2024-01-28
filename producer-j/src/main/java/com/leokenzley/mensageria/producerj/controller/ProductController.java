package com.leokenzley.mensageria.producerj.controller;

import com.leokenzley.mensageria.producerj.constant.ControllerConstant;
import com.leokenzley.mensageria.producerj.service.RabbitMQPrecoService;
import com.leokenzley.mensageria.producerj.service.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "ProductController")
@RequestMapping(ControllerConstant.API_V1+"/preco")
public class ProductController {
    @Autowired
    private RabbitMQPrecoService rabbitMQService;
    @PostMapping
    public ResponseEntity<ProductDTO> sendPreco(@RequestBody ProductDTO dto){
        log.info("send a product: {}", dto.toString());
        rabbitMQService.sendMessage(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
