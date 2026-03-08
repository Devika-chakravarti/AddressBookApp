package com.addressbook.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.addressbook.model.ContactPerson;

public class AddressBookFileIOService {

	public void writeAddressBookToFile(String fileName, String addressBookName, AddressBook addressBook)
			throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		writer.write("Address Book Name : " + addressBookName);
		writer.newLine();
		writer.write("==================================");
		writer.newLine();

		for (ContactPerson person : addressBook.getAllPersons()) {
			writer.write(person.toString());
			writer.newLine();
			writer.write("----------------------------------");
			writer.newLine();
		}

		writer.close();
	}

	public String readAddressBookFromFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		StringBuilder content = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			content.append(line).append("\n");
		}

		reader.close();
		return content.toString();
	}
}