package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.addressbook.model.ContactPerson;

public class ContactTest {

	@Test
	void givenContactDetails_WhenContactCreated_ShouldReturnExpectedString() {
		ContactPerson person = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		String expected = "First Name   : Devika\n" + "Last Name    : Chakravarti\n" + "Address      : Shivajinagar\n"
				+ "City         : Katni\n" + "State        : Madhya Pradesh\n" + "Zip          : 483501\n"
				+ "Phone Number : 9876580098\n" + "Email        : devika@example.com";

		assertEquals(expected, person.toString());
	}

	@Test
	void givenSameNameContacts_WhenCompared_ShouldBeEqual() {
		ContactPerson person1 = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		ContactPerson person2 = new ContactPerson("Devika", "Chakravarti", "Other Address", "Other City", "Other State",
				"111111", "0000000000", "duplicate@example.com");

		assertTrue(person1.equals(person2));
	}

	@Test
	void givenContact_WhenGetCityAndStateCalled_ShouldReturnExpectedValues() {
		ContactPerson person = new ContactPerson("Devika", "Chakravarti", "Shivajinagar", "Katni", "Madhya Pradesh",
				"483501", "9876580098", "devika@example.com");

		assertEquals("Katni", person.getCity());
		assertEquals("Madhya Pradesh", person.getState());
	}
}