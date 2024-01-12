package com.rodigolk.javatest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "password", length = 250)
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
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

    public String getProfileName() {
        return (profile != null) ? profile.getName() : null;
    }

    public User(int id, String name, Profile profile, String email, String password){
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    public User(String name, Profile profile, String email, String password){
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    public User(){}

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
