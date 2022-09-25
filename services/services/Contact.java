package services;

public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    //Validating fields per requirements.
    public boolean idValidation(String id){
        if(id.isEmpty()){
            return false;
        }else if (id.length() > 10){
            return false;
        }else{
            return true;
        }
    }

    public boolean nameValidation(String name){
        if(name.isEmpty()){
            return false;
        }else if (name.length() > 10){
            return false;
        }else{
            return true;
        }
    }

    public boolean phoneNumberValidation(String phone){
        if(phone.isEmpty()){
            return false;
        }else if (phone.length() > 10){
            return false;
        }else{
            return true;
        }
    }

    public boolean addressValidation(String address){
        if(address.isEmpty()){
            return false;
        }else if (address.length() > 30){
            return false;
        }else{
            return true;
        }
    }
    
    //Getters

    public String getContactID() {
        return this.contactID;
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
    
    //Setters for updating established objects. 

    public void setFirstName(String firstName)throws IllegalArgumentException{
        if(this.nameValidation(firstName)){
            this.firstName = firstName;
        }else{
        	throw new IllegalArgumentException("Invalid first name, please enter a name.");
        }
    }

    public void setLastName(String lastName)throws IllegalArgumentException{
        if(this.nameValidation(lastName)){
            this.lastName = lastName;
        }else{
        	throw new IllegalArgumentException("Invalid last name, please enter a name.");
        }
    }

    public void setPhoneNumber(String phoneNumber)throws IllegalArgumentException{
        if(this.phoneNumberValidation(this.phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else{
        	throw new IllegalArgumentException("Invalid phone number, please enter a correct phone number.");
        }
    }

    public void setAddress(String address)throws IllegalArgumentException{
        if(this.addressValidation(address)){
            this.address = address;
        }else{
        	throw new IllegalArgumentException("Invalid address, please enter a correct address.");
        }
    }
    
    //Constructor with validation methods to ensure requirements. 

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) throws IllegalArgumentException  {
        if(this.idValidation(contactID)){
            this.contactID = contactID;
        }else{
        	throw new IllegalArgumentException("Invalid ID, please enter a number or reduce the length.");
        }

        if(this.nameValidation(firstName)){
            this.firstName = firstName;
        }else{
        	throw new IllegalArgumentException("Invalid first name, please enter a name.");
        }

        if(this.nameValidation(lastName)){
            this.lastName = lastName;
        }else{
        	throw new IllegalArgumentException("Invalid last name, please enter a name.");
        }

        if(this.phoneNumberValidation(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else{
        	throw new IllegalArgumentException("Invalid phone number, please enter a correct phone number.");
        }

        if(this.addressValidation(address)){
            this.address = address;
        }else{
        	throw new IllegalArgumentException("Invalid address, please enter a correct address.");
        }
    }
}