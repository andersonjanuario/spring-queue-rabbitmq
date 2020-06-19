package org.spring.queue.config;

import org.spring.queue.constants.ConstantsMq;
import org.spring.queue.exceptions.RabbitExceptionHandler;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitExceptionHandler rabbitExceptionHandler() {
        return new RabbitExceptionHandler();
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(ConstantsMq.EXCHANGE);
    }

    @Bean
    public Queue routingKeyQueue() {
        return QueueBuilder.durable(
                ConstantsMq.ROUTING_KEY)
                .withArgument(ConstantsMq.XDLE, ConstantsMq.EMPTY)
                .withArgument(
                        ConstantsMq.XDLRK,
                        ConstantsMq.ROUTING_KEY_DEAD).build();
    }

    @Bean
    public Queue routingKeyQueueDead() {
        return QueueBuilder.durable(ConstantsMq.ROUTING_KEY_DEAD).build();
    }

    @Bean
    public List<Binding> bindings() {
        return Arrays.asList(
                BindingBuilder.bind(routingKeyQueue()).to(orderExchange()).with(ConstantsMq.ROUTING_KEY)
        );
    }

}
