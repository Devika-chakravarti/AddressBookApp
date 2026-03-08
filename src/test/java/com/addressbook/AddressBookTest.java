package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;

public class AddressBookTest {

	@Test
	void givenMultipleContacts_WhenAddedToAddressBook_ShouldReturnExpectedDetails() {
		ContactPerson person1 = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		ContactPerson person2 = new ContactPerson("Ankit", "Sharma", "Vijay Nagar", "Indore", "Madhya Pradesh",
				"452010", "9999999999", "ankit@example.com");

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person1);
		addressBook.addContact(person2);

		String expected = "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n"
				+ "First Name   : Devika\n" + "Last Name    : Chakravarti\n" + "Address      : Shivajinagar\n"
				+ "City         : Katni\n" + "State        : Madhya Pradesh\n" + "Zip          : 483501\n"
				+ "Phone Number : 9876580098\n" + "Email        : devika@example.com\n"
				+ "----------------------------\n" + "First Name   : Ankit\n" + "Last Name    : Sharma\n"
				+ "Address      : Vijay Nagar\n" + "City         : Indore\n" + "State        : Madhya Pradesh\n"
				+ "Zip          : 452010\n" + "Phone Number : 9999999999\n" + "Email        : ankit@example.com\n"
				+ "----------------------------\n";

		assertEquals(expected, addressBook.toString());
	}

	@Test
	void givenExistingContactName_WhenEdited_ShouldUpdateContactSuccessfully() {
		ContactPerson person = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person);

		boolean result = addressBook.editContactByName("Devika", "Sharma", "Vijay Nagar", "Indore", "Madhya Pradesh",
				"452010", "9999999999", "devika.sharma@example.com");

		assertTrue(result);

		String expected = "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n"
				+ "First Name   : Devika\n" + "Last Name    : Sharma\n" + "Address      : Vijay Nagar\n"
				+ "City         : Indore\n" + "State        : Madhya Pradesh\n" + "Zip          : 452010\n"
				+ "Phone Number : 9999999999\n" + "Email        : devika.sharma@example.com\n"
				+ "----------------------------\n";

		assertEquals(expected, addressBook.toString());
	}

	@Test
	void givenExistingContactName_WhenDeleted_ShouldRemoveContactSuccessfully() {
		ContactPerson person1 = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		ContactPerson person2 = new ContactPerson("Ankit", "Sharma", "Vijay Nagar", "Indore", "Madhya Pradesh",
				"452010", "9999999999", "ankit@example.com");

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person1);
		addressBook.addContact(person2);

		boolean result = addressBook.deleteContactByName("Devika");

		assertTrue(result);

		String expected = "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n" + "First Name   : Ankit\n"
				+ "Last Name    : Sharma\n" + "Address      : Vijay Nagar\n" + "City         : Indore\n"
				+ "State        : Madhya Pradesh\n" + "Zip          : 452010\n" + "Phone Number : 9999999999\n"
				+ "Email        : ankit@example.com\n" + "----------------------------\n";

		assertEquals(expected, addressBook.toString());
	}

	@Test
	void givenDuplicateContact_WhenAddedToAddressBook_ShouldNotBeAdded() {
		ContactPerson person1 = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		ContactPerson duplicatePerson = new ContactPerson("Devika", "Chakravarti", "Other Address", "Other City",
				"Other State", "111111", "0000000000", "duplicate@example.com");

		AddressBook addressBook = new AddressBook();
		boolean firstAddResult = addressBook.addContact(person1);
		boolean duplicateAddResult = addressBook.addContact(duplicatePerson);

		assertTrue(firstAddResult);
		assertFalse(duplicateAddResult);

		String expected = "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n"
				+ "First Name   : Devika\n" + "Last Name    : Chakravarti\n" + "Address      : Shivajinagar\n"
				+ "City         : Katni\n" + "State        : Madhya Pradesh\n" + "Zip          : 483501\n"
				+ "Phone Number : 9876580098\n" + "Email        : devika@example.com\n"
				+ "----------------------------\n";

		assertEquals(expected, addressBook.toString());
	}

	@Test
	void givenMultipleContacts_WhenSortedByName_ShouldReturnAlphabeticalOrder() {
		ContactPerson person1 = new ContactPerson("Rahul", "Verma", "Sector 21", "Noida", "Uttar Pradesh", "201301",
				"8888888888", "rahul@example.com");

		ContactPerson person2 = new ContactPerson("Ankit", "Sharma", "Vijay Nagar", "Indore", "Madhya Pradesh",
				"452010", "9999999999", "ankit@example.com");

		ContactPerson person3 = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person1);
		addressBook.addContact(person2);
		addressBook.addContact(person3);

		List<ContactPerson> sortedPersons = addressBook.getSortedPersonsByName();

		assertEquals("Ankit", sortedPersons.get(0).getFirstName());
		assertEquals("Devika", sortedPersons.get(1).getFirstName());
		assertEquals("Rahul", sortedPersons.get(2).getFirstName());
	}
}