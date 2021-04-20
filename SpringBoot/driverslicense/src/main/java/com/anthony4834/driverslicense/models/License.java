package com.anthony4834.driverslicense.models;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "licenses")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	@NotNull
	private Date expiry;
	private String state;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;
	
	public License(Date exp, String state, Person person) {
		this.expiry = exp;
		this.state = state;
		this.person = person;
		
		this.number = this.genNumber(person.getId());
	}
	
	public License() {
		
	}

	private String genNumber(Long id) {
		String num = "";
		Integer numZeros = 6 - ((Integer) String.valueOf(id).length());
		
		for(int i = 0; i < numZeros; i++) {
			num = num + "0";
		}
		num = num + String.valueOf(id);
		
		return num;
	}
	public Date getDateFromString(String dateString){
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	    Date date = new Date(parsed.getTime());
	    return date;
	}
	
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public Date getExpiry() {
		return expiry;
	}

	public String getState() {
		return state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Person getPerson() {
		return person;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
