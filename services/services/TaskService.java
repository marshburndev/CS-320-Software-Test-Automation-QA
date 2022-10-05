package services;

import java.util.HashMap;
import java.util.Map;

/* The task service shall be able to add tasks with a unique ID.
The task service shall be able to delete tasks per taskId.
The task service shall be able to update task fields per taskId. 
The following fields are updatable: name, description  */

public class TaskService {

  public Map<String, Task> tasks = new HashMap<>();
  int id = 0; // Assigns ID number when object is created

  public void addTask(String name, String description) { // Adds a task, takes in name and description only ID
    // increments with each creation to give inaccessible unique
    // ID.
    id++;
    String newID = Integer.toString(id);
    Task newTask = new Task(newID, name, description);
    tasks.put(newTask.getUniqueTaskId(), newTask);
  }

  public void deleteTask(String id) { // Deletes Task
    if (tasks.containsKey(id)) {
      tasks.remove(id);
    }
  }

  public void updateName(String id, String name) { // Updates Name
    if (tasks.containsKey(id)) {
      tasks.get(id).setName(name);
    }
  }

  public void updateDescription(String id, String description) { // Updates Description
    if (tasks.containsKey(id)) {
      tasks.get(id).setDescription(description);
    }
  }
}
