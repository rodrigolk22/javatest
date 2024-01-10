package com.rodigolk.javatest.DTO;

public class UserUpdateDTO {
    private int id;
    private String name;
    private int profile_id;
    private String email;
    private String password;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


    public UserUpdateDTO(int id, String name, int profile_id, String email, String password){
        this.id = id;
        this.name = name;
        this.profile_id = profile_id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserUpdateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile_id='" + profile_id + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
