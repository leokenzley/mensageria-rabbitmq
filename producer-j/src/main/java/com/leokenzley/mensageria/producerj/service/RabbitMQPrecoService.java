package com.leokenzley.mensageria.producerj.service;

public interface RabbitMQPrecoService {
    void sendMessage(Object mensagem);
}
