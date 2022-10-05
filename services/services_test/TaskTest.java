package services_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import services.Task;

/* The task object shall have a required unique task ID String that cannot be longer than 10 characters. 
The task ID shall not be null and shall not be updatable.
The task object shall have a required name String field that cannot be longer than 20 characters. 
The name field shall not be null. 
The task object shall have a required description String field that cannot be longer than 50 characters. 
The description field shall not be null.
*/

class TaskTest {

  private final String validName = "name";
  private final String id = "1";
  private final String description = "description";
  private final String longerThanSpecifications =
    "idLongerThanTenCharsAndIdLongerthanThirtyChars";
  private final String empty = "";

  // Testing ID requirements

  @Test
  void idWithinSpecifications() {
    Task task = new Task(id, validName, description);
    assertEquals(id, task.getUniqueTaskId());
  }

  @Test
  void idLongerThanTenChar() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Task(longerThanSpecifications, validName, description)
    );
  }

  @Test
  void nullIDException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Task(empty, validName, description)
    );
  }

  // Testing Name requirements

  @Test
  void nameWithinSpecifications() {
    Task task = new Task(id, validName, description);
    assertEquals(validName, task.getName());
  }

  @Test
  void nameLongerThanTwentyChar() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Task(id, longerThanSpecifications, description)
    );
  }

  @Test
  void nameNullException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Task(id, empty, description)
    );
  }

  // Testing Description requirements

  @Test
  void descriptionWithinSpecifications() {
    Task task = new Task(id, validName, description);
    assertEquals(description, task.getDescription());
  }

  @Test
  void descriptionLongerThanFiftyChar() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Task(id, validName, longerThanSpecifications)
    );
  }

  @Test
  void descriptionNullException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Task(id, validName, empty)
    );
  }
}
