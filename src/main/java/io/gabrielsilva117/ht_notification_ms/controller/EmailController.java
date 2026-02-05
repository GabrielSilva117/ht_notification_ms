package io.gabrielsilva117.ht_notification_ms.controller;

import io.gabrielsilva117.ht_notification_ms.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component implements CommandLineRunner
@RequiredArgsConstructor
@RestController
@RequestMapping("/notification")
public class EmailController  {
    private final EmailService emailService;

    @GetMapping("/dispatch")
    public void dispatchMsg() {
        emailService.sendMsg("gabriel.f.silva117@gmail.com", "Test Test", "This was sent by ht_notification_ms");
    }
//    @Override
//    public void run(String... args) {
//        emailService.sendMsg("gabriel.f.silva117@gmail.com", "Test Test", "This was sent by ht_notification_ms");
//    }
}
