package com.emailapp.controller;

import com.emailapp.model.Email;
import com.emailapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable String id) {
        Email email = emailService.getEmailById(id);
        return email != null ? ResponseEntity.ok(email) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Email> sendEmail(@RequestBody Email email) {
        return ResponseEntity.ok(emailService.sendEmail(email));
    }
}
