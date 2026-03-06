package com.addressbook;

import com.addressbook.model.ContactPerson;

public class AddressBookMain {

	public void start() {
		System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

		ContactPerson person = new ContactPerson(
				"Devika",
				"Chakravarti",
				"Shivajinagar",
				"Katni",
				"Madhya Pradesh",
				"483501",
				"9876580098",
				"devika@example.com"
		);

		System.out.println(person);
	}
}