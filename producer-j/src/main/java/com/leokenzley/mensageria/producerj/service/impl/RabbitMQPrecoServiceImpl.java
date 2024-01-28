package com.leokenzley.mensageria.producerj.service.impl;

import com.leokenzley.mensageria.producerj.service.RabbitMQPrecoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPrecoServiceImpl implements RabbitMQPrecoService {
    @Value("${rabbitmq-config.queue.preco.nome}")
    private String queuePreco;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void sendMessage(Object mensagem) {
        this.rabbitTemplate.convertAndSend(queuePreco, mensagem);
    }
}
