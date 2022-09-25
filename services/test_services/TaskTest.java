package test_services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import services.Task;

class TaskTest {
	private String description = "description";
	private String name = "name";
	private String id = "1";
	// Testing ID requirements

	@Test
	void idWithOneChar() {
		Task task = new Task(id, "name", description);
		assertEquals("1", task.getUniqueTaskId());
	}

	@Test
	void idWithTenChar() {
		Task task = new Task("5555555555", name, description);
		assertEquals("5555555555", task.getUniqueTaskId());
	}

	@Test
	void idLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> new Task("55555555555", name, description));
	}

	@Test
	void nullIDException() {
		assertThrows(IllegalArgumentException.class, () -> new Task("", name, description));
	}

	// Testing Name requirements

	@Test
	void nameWithOneChar() {
		Task task = new Task(id, "Y", description);
		assertEquals("Y", task.getName());
	}

	@Test
	void nameLongerThanTwentyChar() {
		assertThrows(IllegalArgumentException.class, () -> new Task(id, "hhhhhhhhhhhhhhhhhhhhh", description));
	}

	@Test
	void nameNullException() {
		assertThrows(IllegalArgumentException.class, () -> new Task(id, "", description));
	}

	// Testing Description requirements

	@Test
	void descriptionWithOneChar() {
		Task task = new Task(id, name, "a");
		assertEquals("a", task.getDescription());
	}

	@Test
	void descriptionLongerThanFiftyChar() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task(id, name, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	@Test
	void descriptionNullException() {
		assertThrows(IllegalArgumentException.class, () -> new Task(id, name, ""));
	}
}
