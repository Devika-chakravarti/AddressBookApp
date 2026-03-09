package com.addressbook.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.addressbook.model.ContactPerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AddressBookJSONService {

	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public void writeAddressBookToJSON(String fileName, AddressBook addressBook) throws IOException {
		try (FileWriter writer = new FileWriter(fileName)) {
			gson.toJson(addressBook.getAllPersons(), writer);
		}
	}

	public List<ContactPerson> readAddressBookFromJSON(String fileName) throws IOException {
		try (FileReader reader = new FileReader(fileName)) {
			Type contactListType = new TypeToken<List<ContactPerson>>() {
			}.getType();
			return gson.fromJson(reader, contactListType);
		}
	}
}