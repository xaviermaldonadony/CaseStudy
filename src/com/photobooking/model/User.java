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
import java.util.*;
import java.util.Set;
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
//    @NotEmpty
    private int id;

	@Column(name="first_name")
    @NotEmpty
    private String firstName;

	@Column(name="last_name")
    @NotEmpty
    private String lastName;

//	TO DO unique=true 
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="credential_id")
	private Credential credential;
	
	// TO D0
//	PaymentDetails paymentDetails;
	
//	If we delete an instructor we don't want to delete the invoice or vice versa.
//	mapped by user in invoice
//	bidirectional
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "user")
	private Set<Invoice> invoices = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "user")
	private Set<PaymentDetails> paymentDetails = new HashSet<>();
	
	
	//    @CreditCardNumber
//    @NotEmpty
//    private String cc;

//	Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setCredntial(Credential credential) {
    	this.credential = credential;
    }
    
    public Credential getcredential() {
    	return this.credential;
    }

    public Set<Invoice> getInvoices(){
    	
    	return invoices;
    }
    public void SetInvoices(Set<Invoice> invoices) {
    	this.invoices = invoices;
    }
    
    // add an invoice to a user and add the user to the invoice;
    public void add(Invoice invoice) {
    	
    	if(invoices == null)
    	{
    		invoices = new HashSet<Invoice>();
    	}
    	invoices.add(invoice);
    	invoice.setUser(this);
    	
    }
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", joinedSince=" + joinedSince + ", phone=" + phone
				+ ", credential=" + credential + "]";
	}
    
    
//    public String getCc() {
//        return cc;
//    }
//
//    public void setCc(String cc) {
//        this.cc = cc;
//    }
}
