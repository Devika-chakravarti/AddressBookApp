package com.addressbook.service;

import com.addressbook.model.ContactPerson;

public class AddressBook {
	private ContactPerson person;

	public void addContact(ContactPerson person) {
		this.person = person;
	}

	public boolean editContactByName(String firstName, String lastName, String address, String city, String state,
			String zip, String phoneNumber, String email) {

		if (person != null && person.getFirstName().equalsIgnoreCase(firstName)) {
			person.updateDetails(lastName, address, city, state, zip, phoneNumber, email);
			return true;
		}
		return false;
	}

	public boolean deleteContactByName(String firstName) {
		if (person != null && person.getFirstName().equalsIgnoreCase(firstName)) {
			person = null;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (person == null) {
			return "ADDRESS BOOK IS EMPTY";
		}

		return "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n" + person;
	}
}