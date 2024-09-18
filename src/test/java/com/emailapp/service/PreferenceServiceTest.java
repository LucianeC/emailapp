package com.emailapp.service;

import com.emailapp.model.Preference;
import com.emailapp.repository.PreferenceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PreferenceServiceTest {

    @Autowired
    private PreferenceService preferenceService;

    @MockBean
    private PreferenceRepository preferenceRepository;

    @Test
    public void testSavePreference() {
        Preference preference = new Preference();
        preference.setUserId("123");
        preference.setTheme("dark");
        preference.setColor("blue");

        when(preferenceRepository.save(preference)).thenReturn(preference);

        Preference savedPreference = preferenceService.savePreference(preference);
        assertNotNull(savedPreference);
        assertEquals("dark", savedPreference.getTheme());
        verify(preferenceRepository, times(1)).save(preference);
    }

    @Test
    public void testGetPreferenceByUserId() {
        Preference preference = new Preference();
        preference.setUserId("123");
        preference.setTheme("dark");

        when(preferenceRepository.findByUserId("123")).thenReturn(Optional.of(preference));

        Optional<Preference> result = preferenceService.getPreferenceByUserId("123");
        assertTrue(result.isPresent());
        assertEquals("dark", result.get().getTheme());
        verify(preferenceRepository, times(1)).findByUserId("123");
    }
}
