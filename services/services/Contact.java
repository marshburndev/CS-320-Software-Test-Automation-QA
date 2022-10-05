package services;

/* The contact object shall have a required unique contact ID String that cannot be longer than 10 characters. 
The contact ID shall not be null and shall not be updatable. 
The contact object shall have a required firstName String field that cannot be longer than 10 characters. 
The firstName field shall not be null. 
The contact object shall have a required lastName String field that cannot be longer than 10 characters. 
The lastName field shall not be null.
The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
The contact object shall have a required address field that must be no longer than 30 characters. 
The address field shall not be null. 
*/

public class Contact {
  private final String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  // Validating fields per requirements.
  public boolean idValidation(String id) {
    //Id length can be no longer than 10 characters & not be null & non-updatable.
    int idLength = 10;
    return !id.isEmpty() && id.length() <= idLength;
}

  public boolean nameValidation(String name) {
    //First and Last name fields must not be longer than 10 characters & not be null.
    int nameLength = 10;
    return !name.isEmpty() && name.length() <= nameLength;
  }

  public boolean phoneNumberValidation(String phone) {
    //Phone number must be 10 digits only & not be null.
    int phoneLength = 10;
    return !phone.isEmpty() && phone.length() == phoneLength;
  }

  public boolean addressValidation(String address) {
    //Address field no longer than 30 characters & not be null.
    int addressLength = 30;
    return !address.isEmpty() && address.length() <= addressLength;
  }

  // Getters

  public String getContactId() {
    return this.contactId;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getAddress() {
    return this.address;
  }

  // Setters for updating established objects.
  // No setter for Id as it is supposed to remain unique and non-updateable. 

  public void setFirstName(String firstName) throws IllegalArgumentException {
    if (this.nameValidation(firstName)) {
      this.firstName = firstName;
    } else {
      throw new IllegalArgumentException(
        "Invalid first name, please enter a name."
      );
    }
  }

  public void setLastName(String lastName) throws IllegalArgumentException {
    if (this.nameValidation(lastName)) {
      this.lastName = lastName;
    } else {
      throw new IllegalArgumentException(
        "Invalid last name, please enter a name."
      );
    }
  }

  public void setPhoneNumber(String phoneNumber)
    throws IllegalArgumentException {
    if (this.phoneNumberValidation(this.phoneNumber)) {
      this.phoneNumber = phoneNumber;
    } else {
      throw new IllegalArgumentException(
        "Invalid phone number, please enter a correct phone number."
      );
    }
  }

  public void setAddress(String address) throws IllegalArgumentException {
    if (this.addressValidation(address)) {
      this.address = address;
    } else {
      throw new IllegalArgumentException(
        "Invalid address, please enter a correct address."
      );
    }
  }

  // Constructor with validation methods to ensure requirements.

  public Contact(
    String contactId,
    String firstName,
    String lastName,
    String phoneNumber,
    String address
  )
    throws IllegalArgumentException {
    if (this.idValidation(contactId)) {
      this.contactId = contactId;
    } else {
      throw new IllegalArgumentException(
        "Invalid ID, please enter a number or reduce the length."
      );
    }

    if (this.nameValidation(firstName)) {
      this.firstName = firstName;
    } else {
      throw new IllegalArgumentException(
        "Invalid first name, please enter a name."
      );
    }

    if (this.nameValidation(lastName)) {
      this.lastName = lastName;
    } else {
      throw new IllegalArgumentException(
        "Invalid last name, please enter a name."
      );
    }

    if (this.phoneNumberValidation(phoneNumber)) {
      this.phoneNumber = phoneNumber;
    } else {
      throw new IllegalArgumentException(
        "Invalid phone number, please enter a correct phone number."
      );
    }

    if (this.addressValidation(address)) {
      this.address = address;
    } else {
      throw new IllegalArgumentException(
        "Invalid address, please enter a correct address."
      );
    }
  }
}
