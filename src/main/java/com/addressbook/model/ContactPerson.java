package com.addressbook.model;

import java.util.Objects;

public class ContactPerson {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public void updateDetails(String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ContactPerson)) {
			return false;
		}

		ContactPerson other = (ContactPerson) obj;
		return firstName.equalsIgnoreCase(other.firstName) && lastName.equalsIgnoreCase(other.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
	}

	@Override
	public String toString() {
		return "First Name   : " + firstName + "\n" + "Last Name    : " + lastName + "\n" + "Address      : " + address
				+ "\n" + "City         : " + city + "\n" + "State        : " + state + "\n" + "Zip          : " + zip
				+ "\n" + "Phone Number : " + phoneNumber + "\n" + "Email        : " + email;
	}
}