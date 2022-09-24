package customer_services;

import java.util.HashMap;

//add task with unique ID
//delete tasks per ID
//update name and description per task ID

public class TaskService {
	public HashMap<String, Task> tasks = new HashMap<String, Task>();
	int ID = 0; //Assigns ID number when object is created
	
	public void addTask(String name, String description) { //Adds a task, takes in name and description only ID increments with each creation to give unaccessible unique ID.
		ID++;
		String newID = Integer.toString(ID);
		Task newTask = new Task(newID, name, description);
		tasks.put(newTask.getUniqueTaskId(), newTask);
	}
	
	public void deleteTask(String ID) { //Deletes Task
		if(tasks.containsKey(ID)) {
			tasks.remove(ID);
		}
	}
	
	public void updateName(String ID, String Name) { //Updates Name
		if(tasks.containsKey(ID)) {
			tasks.get(ID).setName(Name);
		}
	}
	
	public void updateDescription(String ID, String description) { //Updates Description
		if(tasks.containsKey(ID)) {
			tasks.get(ID).setDescription(description);
		}
	}
}
