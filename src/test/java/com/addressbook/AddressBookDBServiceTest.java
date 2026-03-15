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

	@Test
	void givenUpdatedContact_WhenUpdatedInDB_ShouldReturnTrue() {
		AddressBookDBService dbService = new AddressBookDBService();

		ContactPerson updatedPerson = new ContactPerson("Devika", "UpdatedLastName", "UpdatedAddress", "UpdatedCity",
				"UpdatedState", "123456", "9999999999", "updated@example.com");

		boolean result = dbService.updateContactInDB(updatedPerson);

		assertTrue(result);
	}

	@Test
	void givenUpdatedContact_WhenCheckedAgainstDB_ShouldBeInSync() {
		AddressBookDBService dbService = new AddressBookDBService();

		ContactPerson updatedPerson = new ContactPerson("Devika", "UpdatedLastName", "UpdatedAddress", "UpdatedCity",
				"UpdatedState", "123456", "9999999999", "updated@example.com", "2026-03-11");

		dbService.updateContactInDB(updatedPerson);

		boolean isInSync = dbService.isContactInSyncWithDB(updatedPerson);

		assertTrue(isInSync);
	}

	@Test
	void givenDateRange_WhenContactsRetrieved_ShouldReturnContactsAddedInThatPeriod() {
		AddressBookDBService dbService = new AddressBookDBService();

		List<ContactPerson> contacts = dbService.getContactsAddedBetweenDates("2026-03-01", "2026-03-31");

		assertNotNull(contacts);
		assertTrue(contacts.size() >= 0);
	}
}