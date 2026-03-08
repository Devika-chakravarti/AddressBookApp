package com.addressbook;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import com.addressbook.service.AddressBookFileIOService;
import com.addressbook.service.AddressBookSystem;

public class AddressBookMain {

	public void start() {
		Scanner sc = new Scanner(System.in);
		AddressBookSystem addressBookSystem = new AddressBookSystem();
		AddressBookFileIOService fileIOService = new AddressBookFileIOService();

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
		System.out.println("7. Sort Entries in an Address Book by Person Name");
		System.out.println("8. Sort Entries in an Address Book by City");
		System.out.println("9. Sort Entries in an Address Book by State");
		System.out.println("10. Sort Entries in an Address Book by Zip");
		System.out.println("11. Write Address Book to File");
		System.out.println("12. Read Address Book from File");
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
		} else if (choice >= 7 && choice <= 10) {
			System.out.print("Enter Address Book Name: ");
			String addressBookName = sc.nextLine();

			AddressBook addressBook = addressBookSystem.getAddressBook(addressBookName);

			if (addressBook == null) {
				System.out.println("\nAddress Book not found.");
			} else {
				List<ContactPerson> sortedPersons;

				if (choice == 7) {
					sortedPersons = addressBook.getSortedPersonsByName();
					System.out.println("\nSORTED CONTACTS BY PERSON NAME");
				} else if (choice == 8) {
					sortedPersons = addressBook.getSortedPersonsByCity();
					System.out.println("\nSORTED CONTACTS BY CITY");
				} else if (choice == 9) {
					sortedPersons = addressBook.getSortedPersonsByState();
					System.out.println("\nSORTED CONTACTS BY STATE");
				} else {
					sortedPersons = addressBook.getSortedPersonsByZip();
					System.out.println("\nSORTED CONTACTS BY ZIP");
				}

				if (sortedPersons.isEmpty()) {
					System.out.println("\nAddress Book is empty.");
				} else {
					for (ContactPerson person : sortedPersons) {
						System.out.println(person);
						System.out.println("----------------------------");
					}
				}
			}
		} else if (choice == 11) {
			System.out.print("Enter Address Book Name to Write: ");
			String addressBookName = sc.nextLine();

			AddressBook addressBook = addressBookSystem.getAddressBook(addressBookName);

			if (addressBook == null) {
				System.out.println("\nAddress Book not found.");
			} else {
				System.out.print("Enter File Name: ");
				String fileName = sc.nextLine();

				try {
					fileIOService.writeAddressBookToFile(fileName, addressBookName, addressBook);
					System.out.println("\nAddress Book written to file successfully.");
				} catch (IOException e) {
					System.out.println("\nError while writing to file: " + e.getMessage());
				}
			}
		} else if (choice == 12) {
			System.out.print("Enter File Name to Read: ");
			String fileName = sc.nextLine();

			try {
				String fileContent = fileIOService.readAddressBookFromFile(fileName);
				System.out.println("\nFILE CONTENT:\n");
				System.out.println(fileContent);
			} catch (IOException e) {
				System.out.println("\nError while reading file: " + e.getMessage());
			}
		} else {
			System.out.println("Invalid choice.");
		}

		sc.close();
	}
}