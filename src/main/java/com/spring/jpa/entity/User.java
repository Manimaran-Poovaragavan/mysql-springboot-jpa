package com.spring.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_manimaran_spring_jpa")
public class User {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	@Column(name = "id", updatable = false,nullable = false)
	private UUID id ;
	
	@Column(name = "user_name")
	private String username ;
	
	@Column(name = "password")
	private String password ;
	
	@Column(name = "email")
	private String email ;
	
	@Column(name = "join_date")
	private LocalDateTime joindate ;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public LocalDateTime getJoindate() {
		return joindate;
	}

	public void setJoindate(LocalDateTime joindate) {
		this.joindate = joindate;
	}
	

}
