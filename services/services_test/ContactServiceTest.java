package services_test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import services.ContactService;

/* The contact service shall be able to add contacts with unique ID. 
The contact service shall be able to delete contacts per contactId. 
The contact service shall be able to update contact fields per contactId. 
The following fields are updatable: 1. firstName 2. lastName 3. PhoneNumber 4. Address */

class ContactServiceTest {
	// Establishing testing variables.
	private final String name = "test";
	private final String nameLast = "test";
	private final String number = "5555555555";
	private final String address = "street";
	private final String nameUpdate = "updated";
	private final String numUpdate = "777777777";
	private final String addressUpdate = "new address";
	private final String idOne = "1";
	private final String idTwo = "2";
	// Testing setup and initialization
	ContactService contact = new ContactService();

	// Testing unique ID's do not match
	@Test
	void uniqueID() {
		contact.addContact(name, nameLast, number, address);
		contact.addContact(name, nameLast, number, address);
		assertNotEquals(contact.contacts.get(idOne).getContactId(), contact.contacts.get(idTwo).getContactId());
	}

	// Testing contact can be deleted
	@Test
	void deleteContacts() {
		contact.addContact(name, nameLast, number, address);
		contact.addContact(name, nameLast, number, address);
		contact.deleteContact(idOne);
		assertFalse(contact.contacts.containsKey(idOne));
	}

	// Testing First Name Update
	@Test
	void updateFirstName() {
		contact.addContact(name, nameLast, number, address);
		contact.updateFirstName(idOne, nameUpdate);
		assertEquals(nameUpdate, contact.contacts.get(idOne).getFirstName());
	}

	// Testing Last Name Update
	@Test
	void updateLastName() {
		contact.addContact(name, nameLast, number, address);
		contact.updateLastName(idOne, nameUpdate);
		assertEquals(nameUpdate, contact.contacts.get(idOne).getLastName());
	}

	// Testing Phone Number Update
	@Test
	void updatePhoneNumber() {
		contact.addContact(name, nameLast, number, address);
		contact.updatePhone(idOne, numUpdate);
		assertEquals(numUpdate, contact.contacts.get(idOne).getPhoneNumber());
	}

	// Testing Address Update
	@Test
	void updateAddress() {
		contact.addContact(name, nameLast, number, address);
		contact.updateAddress(idOne, addressUpdate);
		assertEquals(addressUpdate, contact.contacts.get(idOne).getAddress());
	}

}
