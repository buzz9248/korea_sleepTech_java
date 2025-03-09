package todo_app.controller;

import java.util.List;

import todo_app.dto.request.UserSignUpReqDto;
import todo_app.dto.response.UserRespDto;
import todo_app.service.UserService;
import todo_app.service.implement.UserServiceImpl;

public class UserController {
	private UserService service;
	
	public UserController() {
		this.service = new UserServiceImpl();
	}
	
	public void signUp(UserSignUpReqDto dto) {
		service.signUp(dto);
	}
	
	public List<UserRespDto> showAllUsers() {
		List<UserRespDto> users = service.showAllUsers();
		return users;
	}
	
	public UserRespDto findUserById(long id) {
		UserRespDto user = service.findUserById(id);
		return user;
	}

	public void deleteUser(long id) {
		service.deleteUser(id);
	}
	
	
	public Long login(String username, String password) {
	    return service.login(username, password);
	}

	

}
