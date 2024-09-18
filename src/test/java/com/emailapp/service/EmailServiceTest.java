package com.emailapp.service;

import com.emailapp.model.Email;
import com.emailapp.repository.EmailRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @MockBean
    private EmailRepository emailRepository;

    @Test
    public void testGetAllEmails() {
        Email email = new Email();
        email.setSender("test@example.com");
        email.setReceiver("receiver@example.com");
        email.setSubject("Test Email");
        email.setDateTime(LocalDateTime.now());

        when(emailRepository.findAll()).thenReturn(List.of(email));

        List<Email> emails = emailService.getAllEmails();
        assertFalse(emails.isEmpty());
        assertEquals("Test Email", emails.get(0).getSubject());
        verify(emailRepository, times(1)).findAll();
    }

    @Test
    public void testSendEmail() {
        Email email = new Email();
        email.setSender("test@example.com");
        email.setReceiver("receiver@example.com");
        email.setSubject("Test Email");
        email.setDateTime(LocalDateTime.now());

        when(emailRepository.save(email)).thenReturn(email);

        Email sentEmail = emailService.sendEmail(email);
        assertNotNull(sentEmail);
        assertEquals("Test Email", sentEmail.getSubject());
        verify(emailRepository, times(1)).save(email);
    }
}
