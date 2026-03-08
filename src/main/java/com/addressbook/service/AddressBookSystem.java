package com.addressbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.addressbook.model.ContactPerson;

public class AddressBookSystem {
	private HashMap<String, AddressBook> addressBookMap = new HashMap<>();

	public boolean addAddressBook(String addressBookName) {
		if (addressBookMap.containsKey(addressBookName)) {
			return false;
		}

		addressBookMap.put(addressBookName, new AddressBook());
		return true;
	}

	public AddressBook getAddressBook(String addressBookName) {
		return addressBookMap.get(addressBookName);
	}

	public List<ContactPerson> searchPersonByCity(String city) {
		return addressBookMap.values().stream().flatMap(addressBook -> addressBook.getPersonsByCity(city).stream())
				.collect(Collectors.toList());
	}

	public List<ContactPerson> searchPersonByState(String state) {
		return addressBookMap.values().stream().flatMap(addressBook -> addressBook.getPersonsByState(state).stream())
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		if (addressBookMap.isEmpty()) {
			return "NO ADDRESS BOOK AVAILABLE";
		}

		String result = "ADDRESS BOOK SYSTEM\n-------------------\n";

		for (String name : addressBookMap.keySet()) {
			result += "Address Book Name : " + name + "\n";
			result += addressBookMap.get(name) + "\n";
		}

		return result;
	}
}