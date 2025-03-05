package chapter06;

import java.util.ArrayList;

// 학생 관리 시스템

class Student {
	// 필드
	int studentId; // 학생 ID
	String name; // 학생 이름
	int age; // 학생 나이
	String major; // 전공
	double gpa; // 평균 학점
	
	// 메서드
	void printStudentInfo() {
		System.out.println("ID: " + studentId
				+ ", Name: " + name
				+ ", Age: " + age
				+ ", Major: " + major
				+ ", Gpa: " + gpa
				);
	}
	
	void updateGpa(double newGpa) {
		this.gpa = newGpa;
	}
	
	// 생성자
	Student() {
		// 필드값 초기화
		this.studentId = 0;
		this.name = "Unknown";
		this.age = 20;
		this.major = "undeclared";
		this.gpa = 0.0;
	}
	
	Student(int studentId, String name, int age, String major, double gpa) {
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.major = major;
		this.gpa = gpa;
	}
	
	Student(int studentId, String name, int age) {
		this.studentId = studentId;
		this.name = name;
		this.age = age;
	}
}

// cf) Java 클래스명은 파일 이름과 동일 (대소문자까지)
//		: 하나의 파일에서 public 단위의 클래스는 한 개만 지정 가능
// 		>> public 클래스명은 파일명과 일치!
public class StudentManagementApp {
	
	static ArrayList<Student> studentList = new ArrayList<>();
//	static ArrayList<Integer> numberList = new ArrayList<>();
	
	// cf) static 메서드
	// : 인스턴스화 없이 클래스 자체에서 직접 호출
	// >> main 메서드 내부에서 다른 메서드 호출 시 반드시 해당 메서드는 static 이어야 함 
	
	// 확생 등록 
	static void addStudent(int id, String name, int age, String major, double gpa) {
		Student student = new Student(id, name, age, major, gpa);
		studentList.add(student);
//		numberList.add(100);
		System.out.println("학생이 등록되었습니다.");
	}
	
	// 모든 학생 출력
	static void printAllStudents() {
		System.out.println("전체 학생 목록");
		for(Student student : studentList) {
			student.printStudentInfo();
		}
	}
	
	// 학생 검색: 학생 ID를 사용하여 해당 학생의 정보를 출력
	static void findStudentById(int studentId) {
		for(Student student : studentList) {
			if(student.studentId == studentId) {
				student.printStudentInfo();
				return; // 메서드 종료
			}
		}
		
		System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
	}
	
	// 평점 업데이트: 학생 ID를 사용하여 해당 학생의 평점을 업데이트
	// >> 매개변수: int studentId, double newGpa
	static void updateStudentGpa(int studentId, double newGpa) {
		for(Student student : studentList) {
			if(student.studentId == studentId) {
				student.updateGpa(newGpa);
				System.out.println("평점이 업데이트 되었습니다.");
				return;
			}
		}
		
		System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
	}
	
	// main 메서드
	// : 프로그램의 진입점을 제공
	// >> public static void main(String[] args) 형식이어야 만 실행 가능
	// >> JVM은 main 메서드가 없을 경우 해당 파일을 실행 X 
	public static void main(String[] args) {
		Student student1 = new Student(1, "문창배1", 27, "전공1", 4.0);
//		Student student2 = new Student(2, "문창배2", 25, "전공2", 3.0);
//		Student student3 = new Student(3, "문창배3", 22, "전공3", 2.0);
//		Student student4 = new Student(4, "문창배4", 24, "전공4", 3.2);
//		studentList.add(student1);
//		studentList.add(student2);
//		studentList.add(student3);
//		studentList.add(student4);
		student1.printStudentInfo();
		
		// 학생 추가
		addStudent(1, "문창배1", 27, "전공1", 4.0);
		addStudent(2, "문창배2", 25, "전공2", 3.0);
		addStudent(3, "문창배3", 22, "전공3", 2.0);
		addStudent(4, "문창배4", 24, "전공4", 3.2);
		
		// 학생 조회 (전체): 모든 학생 출력
		printAllStudents();
		
		// 학생 조회 (단건)
		System.out.println("학생 조회 (단건)");
		findStudentById(3);
		findStudentById(5);
		
		// 학생 평점 업데이트
		updateStudentGpa(1, 3.5);
		updateStudentGpa(2, 4.1);
		
		findStudentById(1);
		findStudentById(2);
	}
}
