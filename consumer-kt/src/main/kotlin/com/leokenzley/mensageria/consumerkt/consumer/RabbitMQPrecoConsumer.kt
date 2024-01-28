package com.leokenzley.mensageria.consumerkt.consumer

import com.leokenzley.mensageria.consumerkt.service.dto.PrecoDTO
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.amqp.core.Message
import org.springframework.amqp.support.converter.MessageConverter

@Component
class RabbitMQPrecoConsumer(
        private val messageConverter: MessageConverter
){
    @RabbitListener(queues = ["\${rabbitmq-config.queue.preco.nome}"])
    fun recebendoMensagemDoRabbitMQ(message: PrecoDTO){
        println("Recebendo a mensagem em JSON do rabbitMQ")
        println(message.toString())
    }
}