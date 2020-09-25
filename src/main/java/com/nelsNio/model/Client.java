package com.nelsNio.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "lastName", length = 50)
	private String lastName;

	@Column(name = "phone", length = 50)
	private String phone;

	@Column(name = "email", length = 50, unique = true)
	private String email;

	@Column(name = "dni", length = 50, unique = true)
	private String dni;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


}
