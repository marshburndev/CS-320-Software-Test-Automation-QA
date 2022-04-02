package task_service;

public class Task {
	private String uniqueTaskId; //no longer than 10 characters, cannot update, non null
	private String name; //no longer than 20 characters, non null
	private String description; //no longer than 50 characters, non null
	
    public boolean idValidation(String ID){ //ID validation
        if(ID.isEmpty()){
            return false;
        }else if (ID.length() > 10){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean nameValidation(String name){ //Name Validation
        if(name.isEmpty()){
            return false;
        }else if (name.length() > 20){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean descriptionValidation(String description){ //Descritpion validation
        if(description.isEmpty()){
            return false;
        }else if (description.length() > 50){
            return false;
        }else{
            return true;
        }
    }
    
    //Getters

	public String getUniqueTaskId() {
		return this.uniqueTaskId;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
	
	//Setters
    
	public void setName(String name) throws IllegalArgumentException {
		if(this.nameValidation(name)) {
			this.name = name;
		}else {
			throw new IllegalArgumentException("Unable to accept name, please enter a valid name.");
		}
	}
	
	public void setDescription(String description) throws IllegalArgumentException {
		if(this.descriptionValidation(description)) {
			this.description = description;
		}else {
			throw new IllegalArgumentException("Unable to accept description, please shorten the description text.");
		}
	}
	
	//Constructor
	
	public Task(String uniqueTaskId, String name, String description) throws IllegalArgumentException{
		if(this.idValidation(uniqueTaskId)) {
			this.uniqueTaskId = uniqueTaskId;
		}else {
			throw new IllegalArgumentException("Invalid ID, too long.");
		}
		
        if(this.nameValidation(name)){
            this.name = name;
        }else{
        	throw new IllegalArgumentException("Invalid first name, too long.");
        }
        
		if(this.descriptionValidation(description)) {
			this.description = description;
		}else {
			throw new IllegalArgumentException("Invalid description, too long.");
		}
	}
}
