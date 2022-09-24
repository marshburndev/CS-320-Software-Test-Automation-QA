package test_customer_services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import customer_services.Task;

class TaskTest {
	
	//Initializing for test cases
	Task task;
	
	//Testing ID requirements

	@Test
	void IdWithOneChar() {
		Task task = new Task("1", "Yeet", "a description");
		assertEquals("1", task.getUniqueTaskId());
	}
	
	@Test
	void IdWithTenChar() {
		Task task = new Task("5555555555", "Yeet", "a description");
		assertEquals("5555555555", task.getUniqueTaskId());
	}
	
	@Test
	void IdLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("55555555555", "Yeet", "a description");
		});
	}
	
	@Test
	void NullIDException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("", "Yeet", "a description");
		});
	}
	
	//Testing Name requirements
	
		@Test
		void NameWithOneChar() {
			Task task = new Task("1", "Y", "a description");
			assertEquals("Y", task.getName());
		}
		
		
		@Test
		void NameLongerThanTwentyChar() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Task("1", "hhhhhhhhhhhhhhhhhhhhh", "a description");
			});
		}
		
		@Test
		void NameNullException() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Task("1", "", "a description");
			});
		}
		
	//Testing Description requirements
		
		@Test
		void DescriptionWithOneChar() {
			Task task = new Task("1", "Y", "a");
			assertEquals("a", task.getDescription());
		}
		
		
		@Test
		void DescriptionLongerThanFiftyChar() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Task("1", "", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			});
		}
		
		@Test
		void DescriptionNullException() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Task("1", "", "");
			});
		}
}