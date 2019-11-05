package com.photobooking.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "required, cannot be empty")
    @Column(name = "FULL_NAME")
    private String name;

    @NotEmpty(message = "required, cannot be empty")
    @Column(name = "USER_PASSWORD")
    private String password;

    @NotEmpty
    @Email
    @Column(name = "USER_EMAIL", unique = true)
    private String email;

    @Past(message = "Date of Birth cannot be in the future")
//    @NotEmpty
    @NotNull
    @Column(name = "USER_DOB")
    private Date dateOfBirth;

    //    @Valid
//    @NotNull
    //TODO: implement some annotations for this (for the weekend)
    private String user;

    public Login() {
    }

    public Login(String name, String email, String password, Date dateOfBirth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
