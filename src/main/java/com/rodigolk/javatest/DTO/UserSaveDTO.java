package com.rodigolk.javatest.DTO;

public class UserSaveDTO {
    
    private String name;
    private ProfileDTO profile;
    private String email;
    private String password;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserSaveDTO(String name, ProfileDTO profile, String email, String password){
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSaveDTO{" +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
