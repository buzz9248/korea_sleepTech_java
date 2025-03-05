package todo_app.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
	private Long id;
	private Long userId;
	private String text;
	private Date creationDate;
//	private boolean isActive;
}
