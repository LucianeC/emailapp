package com.emailapp.service;

import com.emailapp.model.Preference;
import com.emailapp.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    public Preference savePreference(Preference preference) {
        return preferenceRepository.save(preference);
    }

    public Optional<Preference> getPreferenceByUserId(String userId) {
        return preferenceRepository.findByUserId(userId);
    }
}
