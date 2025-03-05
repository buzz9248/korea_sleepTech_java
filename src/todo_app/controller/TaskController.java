package todo_app.controller;

import java.util.List;

import todo_app.dto.request.TaskReqDto;
import todo_app.dto.response.TaskRespDto;
import todo_app.service.TaskService;
import todo_app.service.implement.TaskServiceImpl;

public class TaskController {
	private TaskService service;
	
	public TaskController() {
		this.service = new TaskServiceImpl();
	}
	
	public void createTask(TaskReqDto dto) {
		service.createTask(dto);
	}
	
	public List<TaskRespDto> showAllTasks() {
		return service.showAllTasks();
	}
	
	public void updateTask(Long id, String newText) {
		service.updateTask(id, newText);
	}
	
	public void deleteTask(long id) {
		service.deleteTask(id);
	}
	
	
}
