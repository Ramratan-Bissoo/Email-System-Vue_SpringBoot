package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Receiver")
public class ReceiverEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "S_id")
	private String sender;
	
	@Column(name = "r_id")
	private String receiver;
	
	@Column(name = "Subject")
	private String subject;
	
	@Column(name = "Message",columnDefinition="TEXT")
	private String message;
	
	@Column(name = "Date")
	private String date;

	
	public ReceiverEntity() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "ReceiverEntity [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", subject=" + subject
				+ ", message=" + message + ", date=" + date + ", getId()=" + getId() + ", getSender()=" + getSender()
				+ ", getReceiver()=" + getReceiver() + ", getSubject()=" + getSubject() + ", getMessage()="
				+ getMessage() + ", getDate()=" + getDate() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


		
	
}
