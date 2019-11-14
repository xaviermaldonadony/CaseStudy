package com.photobooking.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity @IdClass(value = AuthoritiesId.class)
@Table(name ="authorities")
//@Table(name ="authorities", uniqueContraints = @UniqueConstraint (columnNmes= {"authority", "username"}))

public class Authorities {
	
	@Id
	@Column(name = "authority")
	private String authority;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "credential_id")
	private Credential credential;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	
	
	
}

class AuthoritiesId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "authority")
	private String authority; 
	
	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private Credential user;

	public String getSecurity() {
		return authority;
	}

	public void setSecurity(String security) {
		this.authority = security;
	}

	public Credential getUser() {
		return user;
	}

	public void setUser(Credential user) {
		this.user = user;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}