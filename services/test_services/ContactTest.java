package test_services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import services.Contact;

class ContactTest {
	String name = "name";
	String nameLast = "name last";
	String number = "5555555555";
	String address = "address";
	String id = "1";
	String nameTen = "aaaaaaaaaa";
	//Testing ID requirements

	@Test
	void idWithOneChar() {
		Contact contact = new Contact(id, name, nameLast, number, address);
		assertEquals("1", contact.getContactID());
	}
	
	@Test
	void idWithTenChar() {
		Contact contact = new Contact("1234567891", name, nameLast, number, address);
		assertEquals("1234567891", contact.getContactID());
	}
	
	@Test
	void idLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact("12345678910", name, nameLast, number, address)
		);
	}
	
	@Test
	void nullIDException() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact("", name, nameLast, number, address)
		);
	}
	
	//Testing First Name requirements
	
	@Test
	void firstNameWithOneChar() {
		Contact contact = new Contact(id, "T", nameLast, number, address);
		assertEquals("T", contact.getFirstName());
	}
	
	@Test
	void firstNameWithTenChar() {
		Contact contact = new Contact(id, nameTen, nameLast, number, address);
		assertEquals(nameTen, contact.getFirstName());
	}
	
	@Test
	void firstNameLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact(id, "aaaaaaaaaaa", nameLast, number, address)
		);
	}
	
	@Test
	void firstNameNullException() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact(id, "",nameLast, number, address)
		);
	}
	
	//Testing Last Name requirements
	
	@Test
	void lastNameWithOneChar() {
		Contact contact = new Contact(id, name, "O", number, address);
		assertEquals("O", contact.getLastName());
	}
	
	@Test
	void lastNameWithTenChar() {
		Contact contact = new Contact(id, name, "bbbbbbbbbb", number, address);
		assertEquals("bbbbbbbbbb", contact.getLastName());
		
	}
	
	@Test
	void lastNameLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact(id, name, "aaaaaaaaaaaa", number, address)
		);
	}
	
	@Test
	void lastNameNullException() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact(id, name, "", number, address)
		);
	}
	
	//Testing Phone requirements
	
	@Test
	void phoneWithTenChar() throws IllegalArgumentException {
		Contact contact = new Contact(id, name, nameLast, number, address);
		assertEquals(number, contact.getPhoneNumber());
	}
	
	
	@Test
	void phoneWithMoreThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact(id, name, nameLast, "55555555555", address)
		);
	}
	
	@Test
	void nullPhoneTest() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact(id, name, nameLast, "", address)
		);
	}
	
	//Testing Address requirements
	
	@Test
	void addressWithOneChar() {
		Contact contact = new Contact(id, name, nameLast, number, "a");
		assertEquals("a", contact.getAddress());
	}
	
	@Test
	void addressWithThirtyChar() {
		Contact contact = new Contact(id, name, nameLast, number, "a street0000000000000000000000");
		assertEquals("a street0000000000000000000000", contact.getAddress());
		
	}
	
	@Test
	void addressLongerThanThirtyChar() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact(id, name, nameLast, number, "a street00000000000000000000000")
		);
	}
	
	@Test
	void addressNullException() {
		assertThrows(IllegalArgumentException.class, () -> 
			new Contact(id, name, nameLast, number, "")
		);
	}
}
