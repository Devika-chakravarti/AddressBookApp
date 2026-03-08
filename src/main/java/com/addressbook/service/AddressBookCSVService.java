package com.addressbook.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.addressbook.model.ContactPerson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBookCSVService {

	public void writeAddressBookToCSV(String fileName, AddressBook addressBook) throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
			String[] header = { "First Name", "Last Name", "Address", "City", "State", "Zip", "Phone Number", "Email" };
			writer.writeNext(header);

			for (ContactPerson person : addressBook.getAllPersons()) {
				String[] data = { person.getFirstName(), person.getLastName(), person.getAddress(), person.getCity(),
						person.getState(), person.getZip(), person.getPhoneNumber(), person.getEmail() };
				writer.writeNext(data);
			}
		}
	}

	public String readAddressBookFromCSV(String fileName) throws IOException {
		StringBuilder content = new StringBuilder();

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			List<String[]> rows = reader.readAll();

			for (String[] row : rows) {
				content.append(String.join(", ", row)).append("\n");
			}
		} catch (Exception e) {
			throw new IOException("Error while reading CSV file", e);
		}

		return content.toString();
	}
}