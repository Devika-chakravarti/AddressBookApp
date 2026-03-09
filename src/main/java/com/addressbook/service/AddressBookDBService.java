package com.addressbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.addressbook.model.ContactPerson;
import com.addressbook.util.DBConnection;

public class AddressBookDBService {

	public List<ContactPerson> getAllContactsFromDB() {
		List<ContactPerson> contactList = new ArrayList<>();

		String query = "SELECT first_name, last_name, address, city, state, zip, phone_number, email FROM contact_person";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				ContactPerson person = new ContactPerson(resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("address"), resultSet.getString("city"),
						resultSet.getString("state"), resultSet.getString("zip"), resultSet.getString("phone_number"),
						resultSet.getString("email"));

				contactList.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contactList;
	}
}