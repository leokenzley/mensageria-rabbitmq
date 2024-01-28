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
    private String productQueueName;
    private final AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queue) {
        return new Queue(queue, true, false, false);
    }

    private DirectExchange exchangeDirect() {
        return new DirectExchange(exchangeDirect);
    }

    private Binding relationShiping(Queue queue, DirectExchange exchange) {
        return new Binding(
                queue.getName(),
                Binding.DestinationType.QUEUE,
                exchange.getName(),
                queue.getName(),
                null);
    }

    @PostConstruct
    private void adiciona(){
        log.info("create a product: {}", productQueueName);
        Queue queueProduct = this.queue(productQueueName);
        log.info("Declare a exchange: {}", exchangeDirect);
        DirectExchange exchange = this.exchangeDirect();
        Binding binding = this.relationShiping(queueProduct, exchange);

        log.info("Declare as queue");
        this.amqpAdmin.declareQueue(queueProduct);
        this.amqpAdmin.declareExchange(exchange);
        this.amqpAdmin.declareBinding(binding);
    }
}

