package services_test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import services.TaskService;

/* The task service shall be able to add tasks with a unique ID.
The task service shall be able to delete tasks per taskId.
The task service shall be able to update task fields per taskId. 
The following fields are updatable: name, description  */

class TaskServiceTest {
	private final String description = "description";
	private final String newDescription = "a new description";
	private final String name = "name";
	private final String newName = "new name";
	private final String idOne = "1";
	private final String idTwo = "2";

	TaskService task = new TaskService(); // initiating object for testing

	// Testing unique ID's do not match
	@Test
	void uniqueID() {
		task.addTask(name, description);
		task.addTask(name, description);
		assertNotEquals(task.tasks.get(idOne).getUniqueTaskId(), task.tasks.get(idTwo).getUniqueTaskId());
	}

	// Testing task can be deleted
	@Test
	void deleteContacts() {
		task.addTask(name, description);
		task.addTask(name, description);
		task.deleteTask(idOne);
		assertFalse(task.tasks.containsKey(idOne));
	}

	// Testing Name Update
	@Test
	void updateName() {
		task.addTask(name, description);
		task.updateName(idOne, newName);
		assertEquals(newName, task.tasks.get(idOne).getName());
	}

	// Testing Description Update
	@Test
	void updateDescription() {
		task.addTask(name, description);
		task.updateDescription(idOne, newDescription);
		assertEquals(newDescription, task.tasks.get(idOne).getDescription());
	}

}