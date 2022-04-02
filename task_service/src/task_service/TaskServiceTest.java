package task_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	TaskService task;
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Print before tests.");
	}
	
	@BeforeEach
	public void setup() {
		task = new TaskService();
	}
	
	@AfterAll
	public static void tearDownAll() {
		System.out.println("Should print after all tests are complete.");
	}

	//Testing unique ID's do not match
	@Test
	void UniqueID() {
		task.addTask("Lionel", "a description");
		task.addTask("Laurent", "a description");
		assertNotEquals(task.tasks.get("1").getUniqueTaskId(),task.tasks.get("2").getUniqueTaskId());
	}
	
	//Testing task can be deleted
	@Test
	void DeleteContacts() {
		task.addTask("Lionel", "a description");
		task.addTask("Laurent", "a description");
		task.deleteTask("1");
		assertFalse(task.tasks.containsKey("1"));
	}
	
	//Testing Name Update
	@Test
	void UpdateName() {
		task.addTask("Lionel", "a description");
		task.updateName("1", "Leo");
		assertEquals("Leo", task.tasks.get("1").getName());
	}
	
	//Testing Description Update
	@Test
	void UpdateDescription() {
		task.addTask("Lionel", "a description");
		task.updateDescription("1", "a new description");
		assertEquals("a new description", task.tasks.get("1").getDescription());
	}

}
