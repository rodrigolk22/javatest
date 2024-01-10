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

    @Column(name = "profile_id", length = 50)
    private int profile_id;

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


    public User(int id, String name, int profile_id, String email, String password){
        this.id = id;
        this.name = name;
        this.profile_id = profile_id;
        this.email = email;
        this.password = password;
    }

    public User(String name, int profile_id, String email, String password){
        this.name = name;
        this.profile_id = profile_id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile_id='" + profile_id + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
