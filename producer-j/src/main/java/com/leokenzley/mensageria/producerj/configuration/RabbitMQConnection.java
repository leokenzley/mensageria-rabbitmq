package com.leokenzley.mensageria.producerj.configuration;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConnection {
    @Value("${rabbitmq-config.exchanges.direta.nome}")
    private String exchangeDirect;

    @Value("${rabbitmq-config.queue.preco.nome}")
    private String queuePreco;
    private final AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String fila) {
        return new Queue(fila, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(exchangeDirect);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca) {
        return new Binding(
                fila.getName(),
                Binding.DestinationType.QUEUE,
                troca.getName(),
                fila.getName(),
                null);
    }

    @PostConstruct
    private void adiciona(){
        log.info("criando a file: {}", queuePreco);
        Queue filaPreco = this.fila(queuePreco);
        log.info("Declarando a exchange: {}", exchangeDirect);
        DirectExchange troca = this.trocaDireta();
        Binding ligacao = this.relacionamento(filaPreco, troca);

        log.info("Declarando as filas");
        this.amqpAdmin.declareQueue(filaPreco);
        this.amqpAdmin.declareExchange(troca);
        this.amqpAdmin.declareBinding(ligacao);
    }
}

