package com.addressbook.service;

import com.addressbook.model.ContactPerson;

public class AddressBook {
	private ContactPerson person;

	public void addContact(ContactPerson person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n" + person;
	}
}