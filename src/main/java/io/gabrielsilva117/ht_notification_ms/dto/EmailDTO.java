package io.gabrielsilva117.ht_notification_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailDTO {
    private String subject;
    private String body;
    private String to;
}
