package todo_app.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import todo_app.dto.request.UserSignUpReqDto;
import todo_app.dto.response.UserRespDto;
import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private static long currentId = 1;
	
	public UserServiceImpl() {
		this.userRepository = UserRepository.getInstane();
	}
	
	private Long generateId() {
		return currentId++;
	}
	

	@Override
	public void signUp(UserSignUpReqDto dto) {
		User user = new User(generateId(), dto.getName(), dto.getUsername(), dto.getPassword());
		userRepository.signUp(user);
	}

	@Override
	public List<UserRespDto> showAllUsers() {
		List<User> users = userRepository.findAllUser();
		
		List<UserRespDto> userRespDtos = users.stream()
				.map(user -> new UserRespDto(user.getName(), user.getUsername()))
				.collect(Collectors.toList());
		
		return userRespDtos;
	}

	@Override
	public UserRespDto findUserById(Long id) {
		UserRespDto userRespDto = null;
		
		try {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다: " + id));
			
			userRespDto = new UserRespDto(user.getName(), user.getUsername());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return userRespDto;
	}

	@Override
	public void deleteUser(Long id) {

		try {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다: " + id));
			
			userRepository.deleteUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
