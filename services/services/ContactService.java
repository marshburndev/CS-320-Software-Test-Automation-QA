package services;

import java.util.HashMap;
import java.util.Map;

/* The contact service shall be able to add contacts with unique ID. 
The contact service shall be able to delete contacts per contactId. 
The contact service shall be able to update contact fields per contactId. 
The following fields are updatable: 1. firstName 2. lastName 3. PhoneNumber 4. Address */

public class ContactService {

  public Map<String, Contact> contacts = new HashMap<>(); // Creating HashMap to store objects.
  int id = 0; // assigns ID number when object is created.

  // Adds a Contact object, ID is decremented and is a unique number and cannot be
  // accessed.
  public void addContact(
    String nameFirst,
    String nameLast,
    String phone,
    String address
  ) {
    id++;
    String newId = Integer.toString(id);
    Contact newContact = new Contact(
      newId,
      nameFirst,
      nameLast,
      phone,
      address
    );
    contacts.put(newContact.getContactId(), newContact);
  }

  // Deletes a Contact object.
  public void deleteContact(String id) {
    contacts.remove(id);
  }

  // Updates an already established first name.
  public void updateFirstName(String id, String firstName) {
    if (contacts.containsKey(id)) {
      contacts.get(id).setFirstName(firstName);
    }
  }

  // Updates an already established last name.
  public void updateLastName(String id, String lastName) {
    if (contacts.containsKey(id)) {
      contacts.get(id).setLastName(lastName);
    }
  }

  // Updates an already established phone number.
  public void updatePhone(String id, String phoneNumber) {
    if (contacts.containsKey(id)) {
      contacts.get(id).setPhoneNumber(phoneNumber);
    }
  }

  // Updates an already established address.
  public void updateAddress(String id, String address) {
    if (contacts.containsKey(id)) {
      contacts.get(id).setAddress(address);
    }
  }
}
