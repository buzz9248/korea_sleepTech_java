package todo_app.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import todo_app.dto.request.TaskReqDto;
import todo_app.dto.response.TaskRespDto;
import todo_app.entity.Task;
import todo_app.entity.User;
import todo_app.repository.TaskRepository;
import todo_app.repository.UserRepository;
import todo_app.service.TaskService;

public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;
	private final UserRepository userRepository;
	
	private static long currentId = 1;
	
	public TaskServiceImpl() {
		this.taskRepository = TaskRepository.getInstance();
		this.userRepository = UserRepository.getInstane();
	}
	
	private Long generatedTaskId() {
		return currentId++;
	}
	
	private void validateUserId(Long userId) {
		Optional<User> foundUser = userRepository.findById(userId);
		
		if(!foundUser.isPresent()) {
			throw new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다: " + userId);
		}
	}
	
	@Override
	public void createTask(TaskReqDto dto) {
		try {
			validateUserId(dto.getUserId());
			
			Task task = new Task(generatedTaskId(), dto.getUserId(), dto.getText(), dto.getCreationDate());
			
			taskRepository.save(task);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<TaskRespDto> showAllTasks() {
		List<TaskRespDto> taskRespDtos = null;
		
		try {
			List<Task> tasks = taskRepository.findAll();
			
			taskRespDtos = tasks.stream()
					.map(task -> new TaskRespDto(task.getId(), task.getUserId(), task.getText(), task.getCreationDate()))
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return taskRespDtos;
	}
	
	@Override
	public void updateTask(Long id, String newText) {
		try {
			Task task = taskRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 할 일을 찾을 수 없습니다." + id));
			
			task.setText(newText);
			System.out.println("수정 완");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	@Override
	public void deleteTask(Long id) {
		try {
			Task task = taskRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다: " + id));
			
			taskRepository.delete(task);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	
}
