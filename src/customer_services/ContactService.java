package customer_services;

import java.util.HashMap;

public class ContactService {
    public HashMap<String, Contact> contacts = new HashMap<String, Contact>();//Creating HashMap to store objects.
    int ID = 0;//assigns ID number when object is created.

    //Adds a Contact object, ID is decremented and is a unique number and cannot be accessed. 
    public void addContact(String nameFirst, String nameLast, String phone, String address){
        ID++;
        String newID = Integer.toString(ID);
        Contact newContact = new Contact(newID, nameFirst, nameLast, phone, address);
        contacts.put(newContact.getContactID(), newContact);
    }

    //Deletes a Contact object. 
    public void deleteContact(String ID){
        contacts.remove(ID);
    }

    //Updates an already established first name. 
    public void updateFirstName(String ID, String firstName) {
        if(contacts.containsKey(ID)){
            contacts.get(ID).setFirstName(firstName);
        }
    }
    //Updates an already established last name. 
    public void updateLastName(String ID, String lastName) {
        if(contacts.containsKey(ID)){
            contacts.get(ID).setLastName(lastName);
        }
    }
    //Updates an already established phone number. 
    public void updatePhone(String ID, String phoneNumber) {
        if (contacts.containsKey(ID)) {
            contacts.get(ID).setPhoneNumber(phoneNumber);
        }
    }
    //Updates an already established address. 
    public void updateAddress(String ID, String address) {
        if (contacts.containsKey(ID)) {
            contacts.get(ID).setAddress(address);
        }
    }
}
