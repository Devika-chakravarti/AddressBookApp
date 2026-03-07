package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;

public class AddressBookTest {

	@Test
	void givenContact_WhenAddedToAddressBook_ShouldReturnExpectedAddressBookDetails() {
		ContactPerson person = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person);

		String expectedOutput = "ADDRESS BOOK CONTACT DETAILS\n" + "----------------------------\n"
				+ "First Name   : Devika\n" + "Last Name    : Chakravarti\n" + "Address      : Shivajinagar\n"
				+ "City         : Katni\n" + "State        : Madhya Pradesh\n" + "Zip          : 483501\n"
				+ "Phone Number : 9876580098\n" + "Email        : devika@example.com";

		assertEquals(expectedOutput, addressBook.toString());
	}
}