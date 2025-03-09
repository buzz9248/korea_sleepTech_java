package todo_app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import todo_app.entity.Task;

public class TaskRepository {
	private List<Task> taskList = new ArrayList<Task>();
	
	private static final TaskRepository instance = new TaskRepository();
	
	public static TaskRepository getInstance() {
		return instance;
	}
	
	public void save(Task task) {
		taskList.add(task);
	}
	
	public Optional<Task> findById(Long id) {
		return taskList.stream()
				.filter(task -> task.getId().equals(id))
				.findFirst();
	}
	
	public List<Task> findAll() {
		return taskList;
	}
	
	public void delete(Task task) {
		taskList.remove(task);
	}

	public List<Task> findByUserId(Long userId) {
	    return taskList.stream()
	        .filter(task -> task.getUserId().equals(userId))
	        .collect(Collectors.toList());
	}


}