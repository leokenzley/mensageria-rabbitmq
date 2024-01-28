package com.leokenzley.mensageria.consumerkt

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class ConsumerktApplication{
	@Bean
	fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter {
		return Jackson2JsonMessageConverter()
	}

}

fun main(args: Array<String>) {
	runApplication<ConsumerktApplication>(*args)
}
