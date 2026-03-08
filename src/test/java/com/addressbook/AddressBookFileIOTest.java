package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import com.addressbook.service.AddressBookFileIOService;

public class AddressBookFileIOTest {

	@Test
	void givenAddressBook_WhenWrittenToFile_ShouldCreateFileWithContent() throws Exception {
		AddressBook addressBook = new AddressBook();
		addressBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		String fileName = "test-addressbook.txt";

		AddressBookFileIOService fileIOService = new AddressBookFileIOService();
		fileIOService.writeAddressBookToFile(fileName, "FamilyBook", addressBook);

		File file = new File(fileName);
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	void givenWrittenFile_WhenRead_ShouldReturnExpectedContent() throws Exception {
		AddressBook addressBook = new AddressBook();
		addressBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		String fileName = "test-addressbook-read.txt";

		AddressBookFileIOService fileIOService = new AddressBookFileIOService();
		fileIOService.writeAddressBookToFile(fileName, "FamilyBook", addressBook);

		String content = fileIOService.readAddressBookFromFile(fileName);

		assertTrue(content.contains("Address Book Name : FamilyBook"));
		assertTrue(content.contains("First Name   : Devika"));
		assertTrue(content.contains("Last Name    : Chakravarti"));

		new File(fileName).delete();
	}
}