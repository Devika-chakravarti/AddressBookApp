package com.addressbook;

import java.util.List;
import java.util.Map;
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

		System.out.println("\nMENU");
		System.out.println("1. Search by City");
		System.out.println("2. Search by State");
		System.out.println("3. View Persons Grouped by City");
		System.out.println("4. View Persons Grouped by State");
		System.out.println("5. Count Persons by City");
		System.out.println("6. Count Persons by State");
		System.out.print("Enter your choice: ");
		int choice = Integer.parseInt(sc.nextLine());

		if (choice == 1) {
			System.out.print("Enter City Name: ");
			String city = sc.nextLine();

			List<ContactPerson> cityResult = addressBookSystem.searchPersonByCity(city);

			if (cityResult.isEmpty()) {
				System.out.println("\nNo person found in city: " + city);
			} else {
				System.out.println("\nPersons found in city: " + city);
				for (ContactPerson person : cityResult) {
					System.out.println(person);
					System.out.println("----------------------------");
				}
			}
		} else if (choice == 2) {
			System.out.print("Enter State Name: ");
			String state = sc.nextLine();

			List<ContactPerson> stateResult = addressBookSystem.searchPersonByState(state);

			if (stateResult.isEmpty()) {
				System.out.println("\nNo person found in state: " + state);
			} else {
				System.out.println("\nPersons found in state: " + state);
				for (ContactPerson person : stateResult) {
					System.out.println(person);
					System.out.println("----------------------------");
				}
			}
		} else if (choice == 3) {
			Map<String, List<ContactPerson>> cityMap = addressBookSystem.viewPersonsByCity();

			if (cityMap.isEmpty()) {
				System.out.println("\nNo city-wise person data available.");
			} else {
				System.out.println("\nPERSONS GROUPED BY CITY");
				for (Map.Entry<String, List<ContactPerson>> entry : cityMap.entrySet()) {
					System.out.println("\nCity: " + entry.getKey());
					for (ContactPerson person : entry.getValue()) {
						System.out.println(person);
						System.out.println("----------------------------");
					}
				}
			}
		} else if (choice == 4) {
			Map<String, List<ContactPerson>> stateMap = addressBookSystem.viewPersonsByState();

			if (stateMap.isEmpty()) {
				System.out.println("\nNo state-wise person data available.");
			} else {
				System.out.println("\nPERSONS GROUPED BY STATE");
				for (Map.Entry<String, List<ContactPerson>> entry : stateMap.entrySet()) {
					System.out.println("\nState: " + entry.getKey());
					for (ContactPerson person : entry.getValue()) {
						System.out.println(person);
						System.out.println("----------------------------");
					}
				}
			}
		} else if (choice == 5) {
			Map<String, Long> cityCountMap = addressBookSystem.getPersonCountByCity();

			if (cityCountMap.isEmpty()) {
				System.out.println("\nNo city-wise count data available.");
			} else {
				System.out.println("\nCOUNT OF PERSONS BY CITY");
				for (Map.Entry<String, Long> entry : cityCountMap.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue());
				}
			}
		} else if (choice == 6) {
			Map<String, Long> stateCountMap = addressBookSystem.getPersonCountByState();

			if (stateCountMap.isEmpty()) {
				System.out.println("\nNo state-wise count data available.");
			} else {
				System.out.println("\nCOUNT OF PERSONS BY STATE");
				for (Map.Entry<String, Long> entry : stateCountMap.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue());
				}
			}
		} else {
			System.out.println("Invalid choice.");
		}

		sc.close();
	}
}