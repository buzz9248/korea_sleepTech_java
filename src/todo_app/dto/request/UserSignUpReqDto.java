package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignUpReqDto {
	private String name;
	private String username;
	private String password;
}
