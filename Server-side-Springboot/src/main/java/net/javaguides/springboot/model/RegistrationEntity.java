package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Registration")

public class RegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fullName")
	private String fullName;
	
	
	@Column(unique = true)
	private String emailId;
	
	@Column(name = "pass")
	private String password;
	
	public RegistrationEntity() {
		super();
	}

	public RegistrationEntity( String fullName, String emailId, String password) {
		super();
		
		this.fullName = fullName;
		this.emailId = emailId;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [id=" + id + ", fullName=" + fullName + ", emailId=" + emailId + ", password="
				+ password + ", getId()=" + getId() + ", getFullName()=" + getFullName() + ", getEmailId()="
				+ getEmailId() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
