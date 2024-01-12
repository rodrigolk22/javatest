package com.rodigolk.javatest.service;

import com.rodigolk.javatest.DTO.ProfileDTO;
import com.rodigolk.javatest.DTO.ProfileSaveDTO;
import com.rodigolk.javatest.DTO.ProfileUpdateDTO;
import com.rodigolk.javatest.entity.Profile;

import java.util.List;

public interface ProfileService {

    Profile getProfile(int id);

    String addProfile(ProfileSaveDTO profileSaveDTO);
 
    List<Profile> getAllProfile();
 
    String updateProfile(ProfileUpdateDTO profileUpdateDTO);
 
    boolean deleteProfile(int id);

    public Profile getProfileByName(String name);
}
