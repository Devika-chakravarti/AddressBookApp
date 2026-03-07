package com.addressbook;

import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;

public class AddressBookMain {

	public void start() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

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

		ContactPerson person = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(person);

		System.out.println("\nCONTACT ADDED SUCCESSFULLY\n");
		System.out.println(addressBook);

		sc.close();
	}
}