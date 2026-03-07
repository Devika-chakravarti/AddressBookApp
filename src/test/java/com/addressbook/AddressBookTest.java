package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}