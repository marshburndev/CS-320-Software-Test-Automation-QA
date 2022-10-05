package services_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import services.Contact;

/* The contact object shall have a required unique contact ID String that cannot be longer than 10 characters. 
The contact ID shall not be null and shall not be updatable. 
The contact object shall have a required firstName String field that cannot be longer than 10 characters. 
The firstName field shall not be null. 
The contact object shall have a required lastName String field that cannot be longer than 10 characters. 
The lastName field shall not be null.
The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
The contact object shall have a required address field that must be no longer than 30 characters. 
The address field shall not be null.  */

class ContactTest {

  private final String validFirstName = "name";
  private final String validLastName = "nameLast";
  private final String number = "5555555555";
  private final String address = "address";
  private final String id = "1";
  private final String longerThanSpecifications =
    "idLongerThanTenCharsAndIdLongerthanThirtyChars";
  private final String empty = "";
  // Testing ID requirements

  @Test
  void idWithinSpecifications() {
    Contact contact = new Contact(id, validFirstName, validLastName, number, address);
    assertEquals(id, contact.getContactId());
  }

  @Test
  void idLongerThanTenCharacters() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(
          longerThanSpecifications,
          validFirstName,
          validLastName,
          number,
          address
        )
    );
  }

  @Test
  void nullIDException() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(
          empty,
          validFirstName,
          validLastName,
          number,
          address
        )
    );
  }

  // Testing First Name requirements
  @Test
  void firstNameWithinSpecifications() {
    Contact contact = new Contact(id, validFirstName, validLastName, number, address);
    assertEquals(validFirstName, contact.getFirstName());
  }

  @Test
  void firstNameLongerThanTenChar() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(
          id,
          longerThanSpecifications,
          validLastName,
          number,
          address
        )
    );
  }

  @Test
  void firstNameNullException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Contact(id, empty, validLastName, number, address)
    );
  }

  // Testing Last Name requirements

  @Test
  void lastNameWithinSpecifications() {
    Contact contact = new Contact(
      id,
      validFirstName,
      validLastName,
      number,
      address
    );
    assertEquals(validLastName, contact.getLastName());
  }

  @Test
  void lastNameLongerThanTenChar() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(
          id,
          validFirstName,
          longerThanSpecifications,
          number,
          address
        )
    );
  }

  @Test
  void lastNameNullException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Contact(id, validFirstName, empty, number, address)
    );
  }

  // Testing Phone requirements

  @Test
  void phoneWithinSpecifications() throws IllegalArgumentException {
    Contact contact = new Contact(id, validFirstName, validLastName, number, address);
    assertEquals(number, contact.getPhoneNumber());
  }

  @Test
  void phoneWithMoreThanTenChar() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(
          id,
          validFirstName,
          validLastName,
          longerThanSpecifications,
          address
        )
    );
  }

  @Test
  void nullPhoneTest() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(id, validFirstName, validLastName, empty, address)
    );
  }

  // Testing Address requirements

  @Test
  void addressWithinSpecifications() {
    Contact contact = new Contact(id, validFirstName, validLastName, number, address);
    assertEquals(address, contact.getAddress());
  }

  @Test
  void addressLongerThanThirtyChar() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(
          id,
          validFirstName,
          validLastName,
          number,
          longerThanSpecifications
        )
    );
  }

  @Test
  void addressNullException() {
    assertThrows(
      IllegalArgumentException.class,
      () ->
        new Contact(id, validFirstName, validLastName, number, empty)
    );
  }
}
