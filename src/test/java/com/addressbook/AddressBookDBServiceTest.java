package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBookDBService;

public class AddressBookDBServiceTest {

	@Test
	void givenDatabase_WhenContactsRetrieved_ShouldReturnContactList() {
		AddressBookDBService dbService = new AddressBookDBService();

		List<ContactPerson> contacts = dbService.getAllContactsFromDB();

		assertNotNull(contacts);
		assertTrue(contacts.size() >= 0);
	}
}