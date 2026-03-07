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

		System.out.print("\nEnter First Name of Contact to Edit: ");
		String nameToEdit = sc.nextLine();

		System.out.println("\nEnter New Details");

		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();

		System.out.print("Enter Address: ");
		String address = sc.nextLine();

		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter State: ");
		String state = sc.nextLine();

		System.out.print("Enter Zip: ");
		String zip = sc.nextLine();

		System.out.print("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();

		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		boolean isUpdated = addressBook.editContactByName(nameToEdit, lastName, address, city, state, zip, phoneNumber,
				email);

		if (isUpdated) {
			System.out.println("\nCONTACT UPDATED SUCCESSFULLY\n");
			System.out.println(addressBook);
		} else {
			System.out.println("\nCONTACT NOT FOUND");
		}

		sc.close();
	}
}