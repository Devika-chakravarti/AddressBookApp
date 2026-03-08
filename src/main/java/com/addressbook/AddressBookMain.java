package com.addressbook;

import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import com.addressbook.service.AddressBookSystem;

public class AddressBookMain {

	public void start() {
		Scanner sc = new Scanner(System.in);
		AddressBookSystem addressBookSystem = new AddressBookSystem();

		System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

		System.out.print("How many Address Books do you want to add? ");
		int numberOfAddressBooks = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= numberOfAddressBooks; i++) {
			System.out.print("\nEnter Name for Address Book " + i + ": ");
			String addressBookName = sc.nextLine();

			boolean isAdded = addressBookSystem.addAddressBook(addressBookName);

			if (!isAdded) {
				System.out.println("Address Book with this name already exists.");
				i--;
				continue;
			}

			AddressBook addressBook = addressBookSystem.getAddressBook(addressBookName);

			System.out.print("How many contacts do you want to add in " + addressBookName + "? ");
			int numberOfContacts = Integer.parseInt(sc.nextLine());

			for (int j = 1; j <= numberOfContacts; j++) {
				System.out.println("\nEnter Details for Contact " + j);

				System.out.print("Enter First Name: ");
				String firstName = sc.nextLine();

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

				ContactPerson person = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber,
						email);

				boolean contactAdded = addressBook.addContact(person);

				if (contactAdded) {
					System.out.println("Contact added successfully.");
				} else {
					System.out.println("Duplicate contact found. Contact not added.");
				}
			}
		}

		System.out.println("\nFINAL ADDRESS BOOK SYSTEM DATA\n");
		System.out.println(addressBookSystem);

		sc.close();
	}
}