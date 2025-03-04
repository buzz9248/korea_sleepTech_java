package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignInReqDto {
	private String username;
	private String password;
}
