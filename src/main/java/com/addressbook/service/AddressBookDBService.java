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

		String query = "SELECT first_name, last_name, address, city, state, zip, phone_number, email, date_added FROM contact_person";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				ContactPerson person = new ContactPerson(resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("address"), resultSet.getString("city"),
						resultSet.getString("state"), resultSet.getString("zip"), resultSet.getString("phone_number"),
						resultSet.getString("email"), resultSet.getString("date_added"));

				contactList.add(person);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to retrieve contacts from database", e);
		}

		return contactList;
	}

	public boolean updateContactInDB(ContactPerson person) {
		String query = "UPDATE contact_person SET last_name = ?, address = ?, city = ?, state = ?, zip = ?, phone_number = ?, email = ? WHERE first_name = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, person.getLastName());
			preparedStatement.setString(2, person.getAddress());
			preparedStatement.setString(3, person.getCity());
			preparedStatement.setString(4, person.getState());
			preparedStatement.setString(5, person.getZip());
			preparedStatement.setString(6, person.getPhoneNumber());
			preparedStatement.setString(7, person.getEmail());
			preparedStatement.setString(8, person.getFirstName());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;

		} catch (Exception e) {
			throw new RuntimeException("Unable to update contact in database", e);
		}
	}

	public ContactPerson getContactByFirstName(String firstName) {
		String query = "SELECT first_name, last_name, address, city, state, zip, phone_number, email, date_added FROM contact_person WHERE first_name = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, firstName);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new ContactPerson(resultSet.getString("first_name"), resultSet.getString("last_name"),
							resultSet.getString("address"), resultSet.getString("city"), resultSet.getString("state"),
							resultSet.getString("zip"), resultSet.getString("phone_number"),
							resultSet.getString("email"), resultSet.getString("date_added"));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to retrieve contact by name from database", e);
		}

		return null;
	}

	public boolean isContactInSyncWithDB(ContactPerson person) {
		ContactPerson dbPerson = getContactByFirstName(person.getFirstName());
		return person.equals(dbPerson);
	}

	public List<ContactPerson> getContactsAddedBetweenDates(String startDate, String endDate) {
		List<ContactPerson> contactList = new ArrayList<>();

		String query = "SELECT first_name, last_name, address, city, state, zip, phone_number, email, date_added "
				+ "FROM contact_person WHERE date_added BETWEEN ? AND ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, startDate);
			preparedStatement.setString(2, endDate);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					ContactPerson person = new ContactPerson(resultSet.getString("first_name"),
							resultSet.getString("last_name"), resultSet.getString("address"),
							resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("zip"),
							resultSet.getString("phone_number"), resultSet.getString("email"),
							resultSet.getString("date_added"));

					contactList.add(person);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to retrieve contacts added in a particular period", e);
		}

		return contactList;
	}

	public int getContactCountByCity(String city) {
		String query = "SELECT COUNT(*) AS contact_count FROM contact_person WHERE city = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, city);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getInt("contact_count");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to retrieve contact count by city", e);
		}

		return 0;
	}

	public int getContactCountByState(String state) {
		String query = "SELECT COUNT(*) AS contact_count FROM contact_person WHERE state = ?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, state);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getInt("contact_count");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to retrieve contact count by state", e);
		}

		return 0;
	}
}