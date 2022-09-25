package services;

import java.util.HashMap;
import java.util.Map;

//add task with unique ID
//delete tasks per ID
//update name and description per task ID

public class TaskService {
	public Map<String, Task> tasks = new HashMap<>();
	int id = 0; //Assigns ID number when object is created
	
	public void addTask(String name, String description) { //Adds a task, takes in name and description only ID increments with each creation to give unaccessible unique ID.
		id++;
		String newID = Integer.toString(id);
		Task newTask = new Task(newID, name, description);
		tasks.put(newTask.getUniqueTaskId(), newTask);
	}
	
	public void deleteTask(String id) { //Deletes Task
		if(tasks.containsKey(id)) {
			tasks.remove(id);
		}
	}
	
	public void updateName(String id, String name) { //Updates Name
		if(tasks.containsKey(id)) {
			tasks.get(id).setName(name);
		}
	}
	
	public void updateDescription(String id, String description) { //Updates Description
		if(tasks.containsKey(id)) {
			tasks.get(id).setDescription(description);
		}
	}
}
