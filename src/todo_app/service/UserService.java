package todo_app.service;

import java.util.List;

import todo_app.dto.request.UserSignUpReqDto;
import todo_app.dto.response.UserRespDto;

public interface UserService {
	void signUp(UserSignUpReqDto dto);
	List<UserRespDto> showAllUsers();
	UserRespDto findUserById(Long id);
	void deleteUser(Long id);
	Long login(String username, String password);

}
