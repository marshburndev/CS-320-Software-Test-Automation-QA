package test_services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import services.TaskService;

class TaskServiceTest {
	private String description = "description";
	private String name = "name";
	private String id = "1";
	TaskService task = new TaskService(); // initiating object for testing

	// Testing unique ID's do not match
	@Test
	void uniqueID() {
		task.addTask(name, description);
		task.addTask(name, description);
		assertNotEquals(task.tasks.get("1").getUniqueTaskId(), task.tasks.get("2").getUniqueTaskId());
	}

	// Testing task can be deleted
	@Test
	void deleteContacts() {
		task.addTask(name, description);
		task.addTask(name, description);
		task.deleteTask(id);
		assertFalse(task.tasks.containsKey("1"));
	}

	// Testing Name Update
	@Test
	void updateName() {
		task.addTask(name, description);
		task.updateName(id, "Leo");
		assertEquals("Leo", task.tasks.get("1").getName());
	}

	// Testing Description Update
	@Test
	void updateDescription() {
		task.addTask(name, description);
		task.updateDescription(id, "a new description");
		assertEquals("a new description", task.tasks.get("1").getDescription());
	}

}