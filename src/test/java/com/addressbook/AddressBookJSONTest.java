package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import com.addressbook.service.AddressBookJSONService;

public class AddressBookJSONTest {

	@Test
	void givenAddressBook_WhenWrittenToJSON_ShouldCreateJSONFile() throws Exception {
		AddressBook addressBook = new AddressBook();
		addressBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		String fileName = "test-addressbook.json";

		AddressBookJSONService jsonService = new AddressBookJSONService();
		jsonService.writeAddressBookToJSON(fileName, addressBook);

		File file = new File(fileName);
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	void givenJSONFile_WhenRead_ShouldReturnExpectedContacts() throws Exception {
		AddressBook addressBook = new AddressBook();
		addressBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		String fileName = "test-addressbook-read.json";

		AddressBookJSONService jsonService = new AddressBookJSONService();
		jsonService.writeAddressBookToJSON(fileName, addressBook);

		List<ContactPerson> persons = jsonService.readAddressBookFromJSON(fileName);

		assertEquals(1, persons.size());
		assertEquals("Devika", persons.get(0).getFirstName());
		assertEquals("Chakravarti", persons.get(0).getLastName());

		new File(fileName).delete();
	}
}