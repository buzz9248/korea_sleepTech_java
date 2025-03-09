package todo_app.service;

import java.util.List;

import todo_app.dto.request.TaskReqDto;
import todo_app.dto.response.TaskRespDto;

public interface TaskService {
	void createTask(TaskReqDto dto);
	List<TaskRespDto> showAllTasks();
	void updateTask(Long id, String newText);
	void deleteTask(Long id);
	List<TaskRespDto> getTasksByUserId(Long userId);

}
