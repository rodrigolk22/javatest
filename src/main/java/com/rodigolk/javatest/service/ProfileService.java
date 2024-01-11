package com.rodigolk.javatest.service;

import com.rodigolk.javatest.DTO.ProfileDTO;
import com.rodigolk.javatest.DTO.ProfileSaveDTO;
import com.rodigolk.javatest.DTO.ProfileUpdateDTO;

import java.util.List;

public interface ProfileService {

    ProfileDTO getProfile(int id);

    String addProfile(ProfileSaveDTO profileSaveDTO);
 
    List<ProfileDTO> getAllProfile();
 
    String updateProfile(ProfileUpdateDTO profileUpdateDTO);
 
    boolean deleteProfile(int id);
}
