package todo_app.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskReqDto {
	private Long userId;
	private String text;
	private Date creationDate;
//	private boolean isActive;
}
