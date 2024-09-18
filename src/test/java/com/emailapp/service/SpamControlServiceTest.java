package com.emailapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpamControlServiceTest {

    @Autowired
    private SpamControlService spamControlService;

    @Test
    public void testIsSpam() {
        String userId = "user123";

        // Enviar 5 e-mails, deve permitir
        for (int i = 0; i < 5; i++) {
            assertFalse(spamControlService.isSpam(userId));
        }

        // Sexto e-mail, deve ser considerado spam
        assertTrue(spamControlService.isSpam(userId));
    }
}
