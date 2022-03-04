package com.melita.ordertaking.config;


import com.melita.ordertaking.constants.AppCons;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    @Bean
    public Queue queue(){
        return new Queue(AppCons.QueueName);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(AppCons.ExchangeName);
    }
    @Bean
    public Binding bind(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(AppCons.RoutingKey);
    }
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
    //Rabbitmq Template
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate  = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return  rabbitTemplate;
    }
}
