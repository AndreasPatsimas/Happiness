package org.patsimas.happy.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
	
	@NotNull
    @Column(name = "username")
    private String username;
	
	@NotNull
    @Column(name = "password")
    private String password;
	
	@NotNull
    @Column(name = "email")
    private String email;
	
    @Column(name = "dob")
	private Date dateOfBirth;
	
	@NotNull
    @Column(name = "doc")
	private Timestamp registrationDate;
	
    @Column(name = "pic")
    private byte [] picture;
    
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    
    @NotNull
    @Column(name = "last_name")
    private String lastName;

	public User() {
		super();
	}

	public User(Long userId, @NotNull String username, @NotNull String password, @NotNull String email,
			Date dateOfBirth, @NotNull Timestamp registrationDate, byte[] picture, @NotNull String firstName,
			@NotNull String lastName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate; //new Timestamp(System.currentTimeMillis());;
		this.picture = picture;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", registrationDate=" + registrationDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
    
    
	
}
