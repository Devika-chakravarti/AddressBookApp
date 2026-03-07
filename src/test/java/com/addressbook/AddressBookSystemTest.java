package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
}