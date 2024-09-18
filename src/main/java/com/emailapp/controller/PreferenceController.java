package com.emailapp.controller;

import com.emailapp.model.Preference;
import com.emailapp.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping
    public ResponseEntity<Preference> savePreference(@RequestBody Preference preference) {
        return ResponseEntity.ok(preferenceService.savePreference(preference));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Preference> getPreference(@PathVariable String userId) {
        Optional<Preference> preference = preferenceService.getPreferenceByUserId(userId);
        return preference.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
