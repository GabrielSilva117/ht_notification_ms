package io.gabrielsilva117.ht_notification_ms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    public static final String NOTIFICATION_EXCHANGE = "notification.exchange";
    public static final String EMAIL_QUEUE = "email_dispatch";
    public static final String EMAIL_ROUTING_KEY = "email.create";

    @Bean
    public DirectExchange notificationExchange() {
        return new DirectExchange(NOTIFICATION_EXCHANGE);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE, true); // durable queue
    }

    @Bean
    public Binding emailBinding(Queue emailQueue, DirectExchange notificationExchange) {
        return BindingBuilder
                .bind(emailQueue())
                .to(notificationExchange())
                .with(EMAIL_ROUTING_KEY);
    }
}
