package todo_app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import todo_app.entity.User;

public class UserRepository {
	List<User> userList = new ArrayList<User>();
	
	private static final UserRepository instance = new UserRepository();
	
	private UserRepository() {}
	
	public static UserRepository getInstane() {
		return instance;
	}
	
	// 회원가입
	public void signUp(User newUser) {
		userList.add(newUser);
	}
	
	public Optional<User> findById(Long id) {
		return userList.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst();
	}
	
	public List<User> findAllUser() {
		return userList;
	}

	public void deleteUser(User user) {
		userList.remove(user);
	}
	
	public User findByUsername(String username) {
	    return userList.stream()
	        .filter(user -> user.getUsername().equals(username))
	        .findFirst()
	        .orElse(null);
	}

}
