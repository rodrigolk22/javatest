package com.rodigolk.javatest.DTO;

public class UserSaveDTO {
    
    private String name;
    private int profile_id;
    private String email;
    private String password;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfile_id() {
        return this.profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
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

    public UserSaveDTO(){}

    public UserSaveDTO(String name, int profile_id, String email, String password){
        this.name = name;
        this.profile_id = profile_id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSaveDTO{" +
                ", name='" + name + '\'' +
                ", profile_id='" + profile_id + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
