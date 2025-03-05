package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRespDto {
	private String name;
	private String username;
}
