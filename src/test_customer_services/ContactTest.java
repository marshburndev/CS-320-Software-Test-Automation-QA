package test_customer_services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import customer_services.Contact;

class ContactTest {
	
	//Testing ID requirements

	@Test
	void IdWithOneChar() {
		Contact contact = new Contact("1", "Titi", "Ortiz", "6656554882", "a street");
		assertEquals("1", contact.getContactID());
	}
	
	@Test
	void IDWithTenChar() {
		Contact contact = new Contact("5555555555", "Robin", "VanPersie", "6656554882", "a street");
		assertEquals("5555555555", contact.getContactID());
	}
	
	@Test
	void IDLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("55555555556", "Lord", "Bendtner", "6656554882", "a street");
		});
	}
	
	@Test
	void NullIDException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "Nicholls", "Lad", "6656554882", "a street");
		});
	}
	
	//Testing First Name requirements
	
	@Test
	void FirstNameWithOneChar() {
		Contact contact = new Contact("1", "T", "Ortiz", "6656554882", "a street");
		assertEquals("T", contact.getFirstName());
	}
	
	@Test
	void FirstNameWithTenChar() {
		Contact contact = new Contact("5555555555", "RobinLeftA", "VanPersie", "6656554882", "a street");
		assertEquals("RobinLeftA", contact.getFirstName());
	}
	
	@Test
	void FirstNameLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("55555555556", "LordScoredALotOfHeaders", "Bendtner", "6656554882", "a street");
		});
	}
	
	@Test
	void FirstNameNullException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "", "Lad", "6656554882", "a street");
		});
	}
	
	//Testing Last Name requirements
	
	@Test
	void LastNameWithOneChar() {
		Contact contact = new Contact("1", "T", "O", "6656554882", "a street");
		assertEquals("O", contact.getLastName());
	}
	
	@Test
	void LastNameWithTenChar() {
		Contact contact = new Contact("5555555555", "RobinLeftA", "VanPersieL", "6656554882", "a street");
		assertEquals("VanPersieL", contact.getLastName());
		
	}
	
	@Test
	void LastNameLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("55555555556", "LordScoredALotOfHeaders", "BendtnerZZ", "6656554882", "a street");
		});
	}
	
	@Test
	void LastNameNullException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "", "", "6656554882", "a street");
		});
	}
	
	//Testing Phone requirements
	
	@Test
	void PhoneWithTenChar() throws IllegalArgumentException {
		Contact contact = new Contact("1", "Ben", "White", "5555555555", "a street");
		assertEquals("5555555555", contact.getPhoneNumber());
	}
	
	@Test
	void PhoneWithLessThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Zlatan", "Ibrahimovic", "555555555", "a street");
		});
	}
	
	@Test
	void PhoneWithMoreThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Alex", "Lacazette", "55555555555", "a street");
		});
	}
	
	@Test
	void NullPhoneTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Martin", "Odegaard", "", "a street");
		});
	}
	
	//Testing Address requirements
	
	@Test
	void AddressWithOneChar() {
		Contact contact = new Contact("1", "T", "O", "6656554882", "a");
		assertEquals("a", contact.getAddress());
	}
	
	@Test
	void AddressWithThirtyChar() {
		Contact contact = new Contact("5555555555", "RobinLeftA", "VanPersieL", "6656554882", "a street0000000000000000000000");
		assertEquals("a street0000000000000000000000", contact.getAddress());
		
	}
	
	@Test
	void AddressLongerThanThirtyChar() {
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("55555555556", "LordScoredALotOfHeaders", "BendtnerZZ", "6656554882", "a street00000000000000000000000");
		});
	}
	
	@Test
	void AddressNullException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "", "", "6656554882", "");
		});
	}
	
}