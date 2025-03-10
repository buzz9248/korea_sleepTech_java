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
    private static Long loggedInUserId = null;

    private static void displayMenu() {
        System.out.println("\n[ 메뉴 선택 ]");
        System.out.println("1. 사용자 등록");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("4. 사용자 정보 조회");
        System.out.println("5. 사용자 삭제");
        System.out.println("6. TODO 추가");
        System.out.println("7. TODO 조회");
        System.out.println("8. TODO 수정");
        System.out.println("9. TODO 삭제");
        System.out.println("10. 프로그램 종료");
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
        System.out.print(prompt + ": ");
        return sc.nextLine().trim();
    }

    private static void login() {
        String username = getInput("사용자 아이디를 입력하세요");
        String password = getInput("비밀번호를 입력하세요");
        
        Long userId = userController.login(username, password);
        if (userId != null) {
            loggedInUserId = userId;
            System.out.println("로그인 완 User ID: " + loggedInUserId);
        } else {
            System.out.println("로그인 실패, 아이디 또는 비밀번호를 확인하세요");
        }
    }

    private static void logout() {
        loggedInUserId = null;
        System.out.println("로그아웃 되었습니다.");
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                UserSignUpReqDto userSignUpReqDto = new UserSignUpReqDto(
                    getInput("사용자 이름"), getInput("사용자 아이디"), getInput("비밀번호")
                );
                userController.signUp(userSignUpReqDto);
                break;
            
            case 2:
                login();
                break;
            
            case 3:
                logout();
                break;
            
            case 4:
                if (loggedInUserId == null) {
                    System.out.println("로그인이 필요합니다.");
                    break;
                }
                UserRespDto user = userController.findUserById(loggedInUserId);
                System.out.println(user);
                break;
            
            case 5:
                if (loggedInUserId == null) {
                    System.out.println("로그인이 필요합니다.");
                    break;
                }
                userController.deleteUser(loggedInUserId);
                loggedInUserId = null;
                System.out.println("사용자가 삭제되었습니다. 자동 로그아웃됩니다.");
                break;
            
            case 6:
                if (loggedInUserId == null) {
                    System.out.println("로그인이 필요합니다.");
                    break;
                }
                TaskReqDto taskReqDto = new TaskReqDto(
                    loggedInUserId, getInput("TODO 입력"), new Date()
                );
                taskController.createTask(taskReqDto);
                break;
            
            case 7:
                if (loggedInUserId == null) {
                    System.out.println("로그인이 필요합니다.");
                    break;
                }
                List<TaskRespDto> tasks = taskController.getTasksByUserId(loggedInUserId);
                if (tasks.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    tasks.forEach(System.out::println);
                }
                break;
            
            case 8:
            	if (loggedInUserId == null) {
                    System.out.println("로그인이 필요합니다.");
                    break;
                }
                List<TaskRespDto> userTasks = taskController.getTasksByUserId(loggedInUserId);
                if (userTasks.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                    break;
                }
                long taskId = Long.parseLong(getInput("수정할 Task ID 입력"));
                String newText = getInput("새로운 TODO 내용 입력");
                taskController.updateTask(taskId, newText);
                break;
            
            case 9:
            	if (loggedInUserId == null) {
                    System.out.println("로그인이 필요합니다.");
                    break;
                }
                List<TaskRespDto> tasksToDelete = taskController.getTasksByUserId(loggedInUserId);
                if (tasksToDelete.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                    break;
                }
                long deleteTaskId = Long.parseLong(getInput("삭제할 Task ID 입력"));
                taskController.deleteTask(deleteTaskId);
                break;
            
            case 10:
                System.out.println("프로그램 종료");
                return false;
            
            default:
                System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요.");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            while (true) {
                displayMenu();
                int choice = getChoice();
                if (!processChoice(choice)) break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
