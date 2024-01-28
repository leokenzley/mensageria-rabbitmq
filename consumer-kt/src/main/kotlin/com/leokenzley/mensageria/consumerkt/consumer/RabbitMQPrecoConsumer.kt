package com.leokenzley.mensageria.consumerkt.consumer

import com.leokenzley.mensageria.consumerkt.service.dto.ProductDTO
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Component

@Component
class RabbitMQPrecoConsumer(
        private val messageConverter: MessageConverter
){
    @RabbitListener(queues = ["\${rabbitmq-config.queue.preco.nome}"])
    fun recivingMessage(message: ProductDTO){
        println("receving a message from RabbitMQ")
        println(message.toString())
    }
}