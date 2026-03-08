package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.addressbook.model.ContactPerson;

public class AddressBook {
	private ArrayList<ContactPerson> personList = new ArrayList<>();

	public boolean addContact(ContactPerson person) {
		boolean isDuplicate = personList.stream().anyMatch(existingPerson -> existingPerson.equals(person));

		if (isDuplicate) {
			return false;
		}

		personList.add(person);
		return true;
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

	public List<ContactPerson> getPersonsByCity(String city) {
		return personList.stream().filter(person -> person.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
	}

	public List<ContactPerson> getPersonsByState(String state) {
		return personList.stream().filter(person -> person.getState().equalsIgnoreCase(state))
				.collect(Collectors.toList());
	}

	public List<ContactPerson> getAllPersons() {
		return new ArrayList<>(personList);
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