package todo_app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import todo_app.controller.TaskController;
import todo_app.controller.UserController;
import todo_app.dto.request.TaskReqDto;
import todo_app.dto.request.UserSignUpReqDto;
import todo_app.dto.response.TaskRespDto;
import todo_app.dto.response.UserRespDto;

/*
 * === TODO(할 일) 프로그램 ===
 * 
 * 1. 프로젝트 개요
 * : 할 일(Todo)에 대한 콘솔 기반 응용 프로그램
 * - 두 도메인(사용자, 할일)을 대상으로 회원가입, 로그인, 로그아웃, 회원 탈퇴 기능
 * 		할일에 대한 추가, 조회(단건/전체), 수정, 삭제 기능을 제공
 * 
 * +) 할일의 활성화 여부(할일 완료 여부)에 따른 필터링
 * 
 * 2. 주요 기능 및 비즈니스 로직
 * : 회원 정보 관리 - CR(단건)D (+ 로그인, 로그아웃)
 * : 할일 기록 관리 - CR(단건/전체)UD (+ 필터링)
 * 
 * 3. 비즈니스 로직 구조
 * - Controller: 사용자의 입력을 처리하고 적절한 서비스 메소드를 호출
 * - Service: 핵심 비즈니스 로직을 수행
 * - Repository: 데이터 저장소와의 상호 작용을 담당
 * - DTO: 계층 간 데이터 전송을 위한 객체
 * - Entity: 데이터베이스 테이블과 매핑되는 도메인 객체
 *
 * 4. 실행 및 관리
 * - Main Class (App.java): 프로그램의 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
 * */
public class App {
	private static final Scanner sc = new Scanner(System.in);
	private static final UserController userController = new UserController();
	private static final TaskController taskController = new TaskController();
	
	private static void displayMenu() {
		System.out.println("\n[ 메뉴 선택 ]");

		System.out.println("1. 사용자 등록");
		System.out.println("2. 사용자 전체 조회");
		System.out.println("3. 사용자 단건 조회");
		System.out.println("4. 사용자 삭제");
		
		System.out.println("5. TODO 추가");
		System.out.println("6. TODO 조회");
		System.out.println("7. TODO 수정"); 
		System.out.println("8. TODO 삭제");
	    System.out.println("9. 프로그램 종료");
	    System.out.print("메뉴를 선택하세요: ");
	}
	
	private static int getChoice() {
		while (!sc.hasNextInt()) {
			System.out.println("숫자를 입력하세요");
			sc.nextLine();
		}
		
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	
	private static String getInput(String prompt) {
		System.out.println(prompt + ": ");
		return sc.nextLine().trim();
	}
	
	private static long getUserIdInput() {
		String input = getInput("UserId를 입력하세요.");
		return Long.parseLong(input);
	}
	
	private static long getTaskIdInput() {
		String input = getInput("TaskId를 입력하세요.");
		return Long.parseLong(input);
	}
	
	private static UserSignUpReqDto signUpUserReq() {
		UserSignUpReqDto dto = null;
		
		try {
			String name = getInput("사용자 이름을 입력하세요");
			String username = getInput("사용자 아이디를 입력하세요");
			String password = getInput("사용자 비밀번호를 입력하세요");
			
			dto = new UserSignUpReqDto(name, username, password);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	
	private static TaskReqDto createTaskReq() {
		TaskReqDto dto = null;
		
		try {
			Long userId = getUserIdInput();
			String text= getInput("TODO를 입력하세요");
			Date creationDate = new Date();
			
			dto = new TaskReqDto(userId, text, creationDate);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	
	
	private static boolean processChoice(int choice) {
		switch (choice) {
		case 1: {
			UserSignUpReqDto userSignUpReqDto = signUpUserReq();
			userController.signUp(userSignUpReqDto);
			break;
		}
		
		case 2: {
			List<UserRespDto> users = userController.showAllUsers();
			if (users.isEmpty()) {
				System.out.println("사용자 정보가 없음");
			} else {
				users.forEach(System.out::println);
			}
			break;
		}
		
		case 3: {
			long id = getUserIdInput();
			UserRespDto user = userController.findUserById(id);
			if (user == null) {
				System.out.println("해당하는 ID의 사용자가 없습니다.");
			} else {
				System.out.println(user);
			}
			break;
		}
		
		case 4: {
			long id = getUserIdInput();
			userController.deleteUser(id);
			break;
		}

		// Task
		case 5: {
			TaskReqDto taskReqDto = createTaskReq();
			taskController.createTask(taskReqDto);
			break;
		}
		
		case 6: {
			List<TaskRespDto> tasks = taskController.showAllTasks();
			if (tasks.isEmpty()) {
				System.out.println("할 일이 없습니다.");
			} else {
				tasks.forEach(System.out::println);
			}
			break;
		}
		
		case 7: {
			long id = getTaskIdInput();
			String newText = getInput("새로운 TODO 내용 입력: ");
			taskController.updateTask(id, newText);
			break;
		}
		case 8: {
			long id = getTaskIdInput();
			taskController.deleteTask(id);
			break;
		}
		
		
		case 9: {
			System.out.println("프로그램 종료");
			return false;
		}
		
		default: {
			System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요.");
			break;
		}
		}
		return true;
	}
	
	public static void main(String[] args) {
		try {
			while (true) {
				displayMenu();
				int choice = getChoice();
				
				if(!processChoice(choice)) break;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}
}