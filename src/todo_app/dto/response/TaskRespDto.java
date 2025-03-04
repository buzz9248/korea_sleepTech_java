package todo_app.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRespDto {
	private Long taskId;
	private Long userId;
	private String text;
	private Date creationDate;
//	private boolean isActive;
}
