package com.emailapp.service;

import com.emailapp.model.Email;
import com.emailapp.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Email getEmailById(String id) {
        return emailRepository.findById(id).orElse(null);
    }

    public Email sendEmail(Email email) {
        return emailRepository.save(email);
    }
}
