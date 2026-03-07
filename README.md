# AddressBookApp - UC1

## Introduction
`AddressBookApp` is a progressive Java and Spring Boot based project developed step by step through multiple use cases.

This README describes the implementation of **UC1**, which is the starting point of the project.

In this use case, the main objective is to create the **ContactPerson** class that represents a single contact in the Address Book. Along with that, the project also includes the basic starter flow using `AddressBookAppApplication` and `AddressBookMain` to display the welcome message.

UC1 is important because it establishes the core contact structure that will be used in all upcoming use cases such as add, edit, delete, and multiple contact management.

---

## UC1 Objective
The objective of UC1 is:

- to create a `ContactPerson` class
- to define all required fields of a contact
- to display a welcome message through `AddressBookMain`
- to prepare the foundation of the Address Book project using Object-Oriented Programming concepts

The contact should contain the following details:

- First Name
- Last Name
- Address
- City
- State
- Zip
- Phone Number
- Email

---

## Problem Statement
Before adding, editing, or deleting contacts, the project first needs a proper structure to represent a single person’s contact details.

So in UC1, the task is to:
- create a `ContactPerson` class
- include all required contact fields
- initialize the object properly
- create the initial starter flow of the application
- display the welcome message

This use case acts as the first building block of the complete Address Book system.

---

## What I Implemented in UC1
In this use case, I implemented:

- a `ContactPerson` class inside the `model` package
- private fields for all required contact details
- a parameterized constructor to initialize object data
- a `toString()` method to display contact details in formatted form
- an `AddressBookMain` class to display the welcome message
- the `AddressBookAppApplication` class to start the Spring Boot application and call `AddressBookMain`
- a unit test class to verify the output of the `ContactPerson` object

At this stage, the project mainly focuses on defining the contact model and the initial program flow.

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
│   │   │       ├── AddressBookMain.java
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
