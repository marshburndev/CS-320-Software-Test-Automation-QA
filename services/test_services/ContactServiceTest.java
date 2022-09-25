package test_services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import services.ContactService;

class ContactServiceTest {
	// Establishing testing variables.
	private String name = "test";
	private String nameLast = "test";
	private String number = "5555555555";
	private String address = "street";
	private String nameUpdate = "updated";
	private String numUpdate = "777777777";
	private String addressUpdate = "new address";
	// Testing setup and initialization
	ContactService contact = new ContactService();

	// Testing unique ID's do not match
	@Test
	void uniqueID() {
		contact.addContact(name, nameLast, number, address);
		contact.addContact(name, nameLast, number, address);
		assertNotEquals(contact.contacts.get("1").getContactID(), contact.contacts.get("2").getContactID());
	}

	// Testing contact can be deleted
	@Test
	void deleteContacts() {
		contact.addContact(name, nameLast, number, address);
		contact.addContact(name, nameLast, number, address);
		contact.deleteContact("1");
		assertFalse(contact.contacts.containsKey("1"));
	}

	// Testing First Name Update
	@Test
	void updateFirstName() {
		contact.addContact(name, nameLast, number, address);
		contact.updateFirstName("1", nameUpdate);
		assertEquals(nameUpdate, contact.contacts.get("1").getFirstName());
	}

	// Testing Last Name Update
	@Test
	void updateLastName() {
		contact.addContact(name, nameLast, number, address);
		contact.updateLastName("1", nameUpdate);
		assertEquals(nameUpdate, contact.contacts.get("1").getLastName());
	}

	// Testing Phone Number Update
	@Test
	void updatePhoneNumber() {
		contact.addContact(name, nameLast, number, address);
		contact.updatePhone("1", numUpdate);
		assertEquals(numUpdate, contact.contacts.get("1").getPhoneNumber());
	}

	// Testing Address Update
	@Test
	void updateAddress() {
		contact.addContact(name, nameLast, number, address);
		contact.updateAddress("1", addressUpdate);
		assertEquals(addressUpdate, contact.contacts.get("1").getAddress());
	}

}
