package com.addressbook;

import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;

public class AddressBookMain {

	public void start() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

		ContactPerson person = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person);

		System.out.println("Existing Contact:");
		System.out.println(addressBook);

		System.out.print("\nEnter First Name of Contact to Delete: ");
		String nameToDelete = sc.nextLine();

		boolean isDeleted = addressBook.deleteContactByName(nameToDelete);

		if (isDeleted) {
			System.out.println("\nCONTACT DELETED SUCCESSFULLY\n");
			System.out.println(addressBook);
		} else {
			System.out.println("\nCONTACT NOT FOUND");
		}

		sc.close();
	}
}