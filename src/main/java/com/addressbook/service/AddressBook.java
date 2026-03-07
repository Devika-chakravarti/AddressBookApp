package com.addressbook.service;

import java.util.ArrayList;

import com.addressbook.model.ContactPerson;

public class AddressBook {
	private ArrayList<ContactPerson> personList = new ArrayList<>();

	public void addContact(ContactPerson person) {
		personList.add(person);
	}

	public boolean editContactByName(String firstName, String lastName, String address, String city, String state,
			String zip, String phoneNumber, String email) {

		for (ContactPerson person : personList) {
			if (person.getFirstName().equalsIgnoreCase(firstName)) {
				person.updateDetails(lastName, address, city, state, zip, phoneNumber, email);
				return true;
			}
		}
		return false;
	}

	public boolean deleteContactByName(String firstName) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
				personList.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return personList.isEmpty();
	}

	@Override
	public String toString() {
		if (personList.isEmpty()) {
			return "ADDRESS BOOK IS EMPTY";
		}

		String result = "ADDRESS BOOK CONTACT DETAILS\n----------------------------\n";

		for (ContactPerson person : personList) {
			result += person + "\n----------------------------\n";
		}

		return result;
	}
}