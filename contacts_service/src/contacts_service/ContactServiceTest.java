package contacts_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	//Testing setup and initialization
	ContactService contact;
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Print before tests.");
	}
	
	@BeforeEach
	public void setup() {
		contact = new ContactService();
	}
	
	@AfterAll
	public static void tearDownAll() {
		System.out.println("Should print after all tests are complete.");
	}
	

	//Testing unique ID's do not match
	@Test
	void UniqueID() {
		contact.addContact("Lionel", "Messi", "5555555555", "a street");
		contact.addContact("Laurent", "Koscielny", "5555555554", "a street1");
		assertNotEquals(contact.contacts.get("1").getContactID(), contact.contacts.get("2").getContactID());
	}
	
	//Testing contact can be deleted
	@Test
	void DeleteContacts() {
		contact.addContact("Lionel", "Messi", "5555555555", "a street");
		contact.addContact("Laurent", "Koscielny", "5555555554", "a street1");
		contact.deleteContact("1");
		assertFalse(contact.contacts.containsKey("1"));
	}
	
	//Testing First Name Update
	@Test
	void UpdateFirstName() {
		contact.addContact("Lionel", "Messi", "5555555555", "a street");
		contact.updateFirstName("1", "Leo");
		assertEquals("Leo", contact.contacts.get("1").getFirstName());
	}
	
	//Testing Last Name Update
	@Test
	void UpdateLastName() {
		contact.addContact("Lionel", "Messi", "5555555555", "a street");
		contact.updateLastName("1", "Ronaldo");
		assertEquals("Ronaldo", contact.contacts.get("1").getLastName());
	}
	
	//Testing Phone Number Update
	@Test
	void UpdatePhoneNumber() {
		contact.addContact("Jack", "Wilshere", "5555555555", "a street");
		contact.updatePhone("1", "7777777777");
		assertEquals("7777777777", contact.contacts.get("1").getPhoneNumber());
	}
	
	//Testing Address Update
	@Test
	void UpdateAddress() {
		contact.addContact("Jack", "Wilshere", "5555555555", "a street");
		contact.updateAddress("1", "a street1");
		assertEquals("a street1", contact.contacts.get("1").getAddress());
	}
	
}
