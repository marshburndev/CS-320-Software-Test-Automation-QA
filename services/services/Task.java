package services;

/* The task object shall have a required unique task ID String that cannot be longer than 10 characters. 
The task ID shall not be null and shall not be updatable.
The task object shall have a required name String field that cannot be longer than 20 characters. 
The name field shall not be null. 
The task object shall have a required description String field that cannot be longer than 50 characters. 
The description field shall not be null.
*/

public class Task {

  private final String uniqueTaskId;
  private String name;
  private String description;

  public boolean idValidation(String id) { // ID validation
    //Id length can be no longer than 10 characters & not be null & non-updatable.
    int idLength = 10;
    return !id.isEmpty() && id.length() <= idLength;
  }

  public boolean nameValidation(String name) { // Name Validation
    //Name fields must not be longer than 20 characters & not be null.
    int nameLength = 20;
    return !name.isEmpty() && name.length() <= nameLength;
  }

  public boolean descriptionValidation(String description) { // Description validation
    //Description field no longer than 30 characters & not be null.
    int descriptionLength = 30;
    return !description.isEmpty() && description.length() <= descriptionLength;
  }

  // Getters

  public String getUniqueTaskId() {
    return this.uniqueTaskId;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  // Setters
  // No setter for Id as this must not be updatable.

  public void setName(String name) throws IllegalArgumentException {
    if (this.nameValidation(name)) {
      this.name = name;
    } else {
      throw new IllegalArgumentException(
        "Unable to accept name, please enter a valid name."
      );
    }
  }

  public void setDescription(String description)
    throws IllegalArgumentException {
    if (this.descriptionValidation(description)) {
      this.description = description;
    } else {
      throw new IllegalArgumentException(
        "Unable to accept description, please shorten the description text."
      );
    }
  }

  // Constructor

  public Task(String uniqueTaskId, String name, String description)
    throws IllegalArgumentException {
    if (this.idValidation(uniqueTaskId)) {
      this.uniqueTaskId = uniqueTaskId;
    } else {
      throw new IllegalArgumentException("Invalid ID, too long.");
    }

    if (this.nameValidation(name)) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Invalid first name, too long.");
    }

    if (this.descriptionValidation(description)) {
      this.description = description;
    } else {
      throw new IllegalArgumentException("Invalid description, too long.");
    }
  }
}
