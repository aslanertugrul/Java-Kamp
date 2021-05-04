package Entities;

import java.time.LocalDate;

public class Customer {

	private int id;
	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private String nationalityID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationalityID() {
		return nationalityID;
	}
	public void setNationalityID(String nationalityID) {
		this.nationalityID = nationalityID;
	}
	
	
}
