package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import com.addressbook.service.AddressBookCSVService;

public class AddressBookCSVTest {

	@Test
	void givenAddressBook_WhenWrittenToCSV_ShouldCreateCSVFile() throws Exception {
		AddressBook addressBook = new AddressBook();
		addressBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		String fileName = "test-addressbook.csv";

		AddressBookCSVService csvService = new AddressBookCSVService();
		csvService.writeAddressBookToCSV(fileName, addressBook);

		File file = new File(fileName);
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	void givenCSVFile_WhenRead_ShouldReturnExpectedContent() throws Exception {
		AddressBook addressBook = new AddressBook();
		addressBook.addContact(new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com"));

		String fileName = "test-addressbook-read.csv";

		AddressBookCSVService csvService = new AddressBookCSVService();
		csvService.writeAddressBookToCSV(fileName, addressBook);

		String content = csvService.readAddressBookFromCSV(fileName);

		assertTrue(content.contains("First Name, Last Name, Address, City, State, Zip, Phone Number, Email"));
		assertTrue(content.contains(
				"Devika, Chakravarti, Shivajinagar, Katni, Madhya Pradesh, 483501, 9876580098, devika@example.com"));

		new File(fileName).delete();
	}
}