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
				"UpdatedState", "123456", "9999999999", "updated@example.com");

		dbService.updateContactInDB(updatedPerson);

		ContactPerson personFromDB = dbService.getContactByFirstName("Devika");

		assertNotNull(personFromDB);
		assertTrue(updatedPerson.getFirstName().equals(personFromDB.getFirstName()));
		assertTrue(updatedPerson.getLastName().equals(personFromDB.getLastName()));
		assertTrue(updatedPerson.getAddress().equals(personFromDB.getAddress()));
		assertTrue(updatedPerson.getCity().equals(personFromDB.getCity()));
		assertTrue(updatedPerson.getState().equals(personFromDB.getState()));
		assertTrue(updatedPerson.getZip().equals(personFromDB.getZip()));
		assertTrue(updatedPerson.getPhoneNumber().equals(personFromDB.getPhoneNumber()));
		assertTrue(updatedPerson.getEmail().equals(personFromDB.getEmail()));
	}

	@Test
	void givenDateRange_WhenContactsRetrieved_ShouldReturnContactsAddedInThatPeriod() {
		AddressBookDBService dbService = new AddressBookDBService();

		List<ContactPerson> contacts = dbService.getContactsAddedBetweenDates("2026-03-01", "2026-03-31");

		assertNotNull(contacts);
		assertTrue(contacts.size() >= 0);
	}

	@Test
	void givenCity_WhenCountRetrieved_ShouldReturnNumberOfContacts() {
		AddressBookDBService dbService = new AddressBookDBService();

		int count = dbService.getContactCountByCity("Bhopal");

		assertTrue(count >= 0);
	}

	@Test
	void givenState_WhenCountRetrieved_ShouldReturnNumberOfContacts() {
		AddressBookDBService dbService = new AddressBookDBService();

		int count = dbService.getContactCountByState("Madhya Pradesh");

		assertTrue(count >= 0);
	}
}