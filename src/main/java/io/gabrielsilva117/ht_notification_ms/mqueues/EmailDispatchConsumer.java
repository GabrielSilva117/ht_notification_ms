package io.gabrielsilva117.ht_notification_ms.mqueues;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gabrielsilva117.ht_notification_ms.config.MQConfig;
import io.gabrielsilva117.ht_notification_ms.dto.EmailDTO;
import io.gabrielsilva117.ht_notification_ms.dto.EmailRequest;
import io.gabrielsilva117.ht_notification_ms.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailDispatchConsumer {
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    @RabbitListener(queues = MQConfig.EMAIL_QUEUE)
    public void dispatchEmailMessage(String msg) {
        try {
            EmailDTO dto = objectMapper.readValue(msg, EmailDTO.class);
            this.emailService.sendMsg(dto.getTo(), dto.getSubject(), dto.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
