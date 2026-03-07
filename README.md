# AddressBookApp 

## Introduction
`AddressBookApp` is a progressive Java and Spring Boot based project in which the Address Book system is being built one use case at a time.

In this use case, the main goal is to create the **ContactPerson** class that represents a single contact in the address book. This class stores all the required details of a person and acts as the base model for the upcoming use cases.

UC1 is important because all later functionalities such as adding a contact, editing a contact, deleting a contact, and managing multiple contacts depend on this contact structure.

---

## UC1 Objective
The objective of UC1 is to design a class that can store the complete information of one contact person in the Address Book.

The contact should contain the following details:

- First Name
- Last Name
- Address
- City
- State
- Zip
- Phone Number
- Email

This use case focuses on creating the basic data structure of the project using Object-Oriented Programming concepts.

---

## Problem Statement
Before performing operations like add, edit, or delete, the project first needs a proper representation of a person’s contact details.

So in UC1, the task is to:
- define a `ContactPerson` class
- include all required fields
- initialize the object using a constructor
- display the contact details in a proper format

This is the first step in building a complete Address Book system.

---

## What I Implemented in UC1
In this use case, I implemented:

- a `ContactPerson` class inside the `model` package
- private fields for all required contact details
- a parameterized constructor to initialize object data
- a `toString()` method to display contact details in formatted form
- a unit test class to verify the output of the contact object

At this stage, the project focuses only on defining the contact entity correctly.

---

## Project Structure for UC1

```text
AddressBookApp
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.addressbook
│   │   │       ├── AddressBookAppApplication.java
│   │   │       └── model
│   │   │           └── ContactPerson.java
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java
│           └── com.addressbook
│               ├── AddressBookAppApplicationTests.java
│               └── ContactTest.java
│
├── pom.xml
├── .gitignore
└── README.md
