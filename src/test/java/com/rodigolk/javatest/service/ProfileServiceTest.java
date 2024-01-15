package com.rodigolk.javatest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.rodigolk.javatest.DTO.ProfileSaveDTO;
import com.rodigolk.javatest.ProfileRepo.ProfileRepo;
import com.rodigolk.javatest.entity.Profile;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @Mock
    private ProfileRepo profileRepo;

    @InjectMocks
    private ProfileServiceIMPL profileService;

    @Test
    void getAllProfile() {
        Profile profile1 = new Profile(1, "Admin");
        Profile profile2 = new Profile(2, "User");
        List<Profile> mockProfiles = Arrays.asList(profile1, profile2);

        when(profileRepo.findAll()).thenReturn(mockProfiles);

        List<Profile> result = profileService.getAllProfile();

        assertEquals(2, result.size());
        assertEquals("Admin", result.get(0).getName());
        assertEquals("User", result.get(1).getName());

        verify(profileRepo, times(1)).findAll();
    }

    @Test
    void createProfile() {
        ProfileSaveDTO profileRequest = new ProfileSaveDTO("NewProfile");
        Profile createdProfile = new Profile(1, "NewProfile");

        when(profileRepo.save(any(Profile.class))).thenReturn(createdProfile);
        
        String result = profileService.addProfile(profileRequest);

        assertNotNull(result);
        assertEquals("NewProfile", createdProfile.getName());

        verify(profileRepo, times(1)).save(argThat(profile ->
            profile.getName().equals("NewProfile")
        ));
    }
}
