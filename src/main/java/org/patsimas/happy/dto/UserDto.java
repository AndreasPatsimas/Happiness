package org.patsimas.happy.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.patsimas.happy.domain.Role;
import org.patsimas.happy.utils.CsvBindByNameOrder;

import com.opencsv.bean.CsvBindByName;

@CsvBindByNameOrder({ "ID", "USERNAME", "PASSWORD", "EMAIL", "DATE OF BIRTH", "DATE OF REGISTRATION", "IMAGE",
		"FIRSTNAME", "LASTNAME", "ROLES" })
public class UserDto {

	@CsvBindByName(column = "ID")
	private Long userId;

	@CsvBindByName(column = "USERNAME")
	private String username;

	@CsvBindByName(column = "PASSWORD")
	private String password;

	@CsvBindByName(column = "EMAIL")
	private String email;

	@CsvBindByName(column = "DATE OF BIRTH")
	private Date dateOfBirth;

	@CsvBindByName(column = "DATE OF REGISTRATION")
	private Date registrationDate;

	@CsvBindByName(column = "IMAGE")
	private byte[] picture;

	@CsvBindByName(column = "FIRSTNAME")
	private String firstName;

	@CsvBindByName(column = "LASTNAME")
	private String lastName;

	@CsvBindByName(column = "ROLES")
	private List<Role> roles;

	public UserDto() {
		super();
	}

	public UserDto(Long userId, String username, String password, String email, Date dateOfBirth, Date registrationDate,
			byte[] picture, String firstName, String lastName, List<Role> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate; // new Timestamp(System.currentTimeMillis());;
		this.picture = picture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", username=" + username + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", registrationDate=" + registrationDate + ", picture=" + Arrays.toString(picture)
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", roles=" + roles + "]";
	}

}
