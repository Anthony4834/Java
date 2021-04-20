package com.anthony4834.driverslicense.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(min = 3, max = 255)
	private String firstName;
	@Size(min = 3, max = 355)
	private String lastName;
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person() {
		
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public License getLicense() {
		return license;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
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
