package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import com.addressbook.service.AddressBookSystem;

public class AddressBookSystemTest {

	@Test
	void givenNewAddressBookName_WhenAdded_ShouldReturnTrue() {
		AddressBookSystem system = new AddressBookSystem();

		boolean result = system.addAddressBook("FamilyBook");

		assertTrue(result);
		assertNotNull(system.getAddressBook("FamilyBook"));
	}

	@Test
	void givenDuplicateAddressBookName_WhenAdded_ShouldReturnFalse() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("FamilyBook");
		boolean result = system.addAddressBook("FamilyBook");

		assertFalse(result);
	}

	@Test
	void givenMultipleAddressBooks_WhenSearchByCity_ShouldReturnMatchingPersons() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("FamilyBook");
		system.addAddressBook("FriendsBook");

		AddressBook familyBook = system.getAddressBook("FamilyBook");
		AddressBook friendsBook = system.getAddressBook("FriendsBook");

		familyBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		friendsBook.addContact(new ContactPerson("Ankit", "Sharma", "Vijay Nagar", "Katni", "Madhya Pradesh", "452010",
				"9999999999", "ankit@example.com"));

		List<ContactPerson> result = system.searchPersonByCity("Katni");

		assertEquals(2, result.size());
	}

	@Test
	void givenMultipleAddressBooks_WhenSearchByState_ShouldReturnMatchingPersons() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("FamilyBook");
		system.addAddressBook("OfficeBook");

		AddressBook familyBook = system.getAddressBook("FamilyBook");
		AddressBook officeBook = system.getAddressBook("OfficeBook");

		familyBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		officeBook.addContact(new ContactPerson("Rahul", "Verma", "Sector 21", "Noida", "Uttar Pradesh", "201301",
				"8888888888", "rahul@example.com"));

		List<ContactPerson> result = system.searchPersonByState("Madhya Pradesh");

		assertEquals(1, result.size());
		assertEquals("Devika", result.get(0).getFirstName());
	}

	@Test
	void givenMultipleAddressBooks_WhenViewedByCity_ShouldReturnCityPersonDictionary() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("FamilyBook");
		system.addAddressBook("FriendsBook");

		AddressBook familyBook = system.getAddressBook("FamilyBook");
		AddressBook friendsBook = system.getAddressBook("FriendsBook");

		familyBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		friendsBook.addContact(new ContactPerson("Ankit", "Sharma", "Vijay Nagar", "Indore", "Madhya Pradesh", "452010",
				"9999999999", "ankit@example.com"));

		Map<String, List<ContactPerson>> cityMap = system.viewPersonsByCity();

		assertEquals(2, cityMap.size());
		assertEquals(1, cityMap.get("Katni").size());
		assertEquals(1, cityMap.get("Indore").size());
	}

	@Test
	void givenMultipleAddressBooks_WhenViewedByState_ShouldReturnStatePersonDictionary() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("FamilyBook");
		system.addAddressBook("OfficeBook");

		AddressBook familyBook = system.getAddressBook("FamilyBook");
		AddressBook officeBook = system.getAddressBook("OfficeBook");

		familyBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		officeBook.addContact(new ContactPerson("Rahul", "Verma", "Sector 21", "Noida", "Uttar Pradesh", "201301",
				"8888888888", "rahul@example.com"));

		Map<String, List<ContactPerson>> stateMap = system.viewPersonsByState();

		assertEquals(2, stateMap.size());
		assertEquals(1, stateMap.get("Madhya Pradesh").size());
		assertEquals(1, stateMap.get("Uttar Pradesh").size());
	}
}