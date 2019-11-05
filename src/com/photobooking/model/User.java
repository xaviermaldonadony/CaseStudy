package com.photobooking.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.CreditCardNumber;

import com.photobooking.model.Authorities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
//    @NotEmpty
    private long id;

	@Column(name="first_name")
    @NotEmpty
    private String firstName;

	@Column(name="last_name")
    @NotEmpty
    private String lastName;

	@Column(name="email")
    @NotEmpty
    private String email;
	
	@Column(name="date_of_birth")
    @Past(message = "Date of Birth cannot be in the future")
    @NotEmpty
    private Date dateOfBirth;

	@Column(name="joined_since")
    @CreationTimestamp //Hibernate Annotation
    private Date joinedSince;

//    @Valid
//    @NotNull
//    private Address address;

	@Column(name="phone")
    @Pattern(regexp = "\\d{10}") //regex expects 10 digits
    @NotEmpty
    private String phone;

//	@OneToMany(cascade = CascadeType.ALL)
//	private Set<Authorities> authorities = new HashSet<>();
	//    @CreditCardNumber
//    @NotEmpty
//    private String cc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Date getJoinedSince() {
        return joinedSince;
    }

    public void setJoinedSince(Date joinedSince) {
        this.joinedSince = joinedSince;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getCc() {
//        return cc;
//    }
//
//    public void setCc(String cc) {
//        this.cc = cc;
//    }
}
