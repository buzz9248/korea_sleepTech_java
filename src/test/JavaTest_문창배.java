package test;

import java.util.Scanner;

class Student {
	public String name;
	public int score;
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
}

public class JavaTest_문창배 {
	public static void main(String[] args) {
		// 1. 서술형
		// - 기본 데이터 타입: 
		// 데이터값 저장
		// byte, short, long, float
		// int, double, char, boolean
		// int a = 10;
		
		
		// - 참조 데이터 타입: 
		// 데이터값의 주소 저장
		// String
		// String abc = "abc";

		// 2. 코드 구현 문제
		int num1 = 10;
		double num2 = 3.5;
		double result = num1 + num2;
		System.out.println(result);
		
		// 3. 코드 구현 문제
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (input % 2 == 0) {
			System.out.println("입력하신 숫자는 짝수입니다.");
		} else {
			System.out.println("입력하신 숫자는 홀수입니다.");
		}
		
		sc.close();
		
		// 4. 코드 구현 문제
		int[] numbers = {1, 2, 3, 4, 5};
		
		for (int i : numbers) {
			System.out.println(i);
		}
		
		// 5. 코드 구현 문제
		Student student1 = new Student("John", 85);
		Student student2 = new Student("Jane", 92);
		Student student3 = new Student("Tom", 78);
		Student student4 = new Student("Emily", 88);
		Student student5 = new Student("Alex", 95);
		
		Student[] students = {student1, student2, student3, student4, student5};
		
		for (int i = 0; i <= students.length; i++) {
			if(students[i].score >= 90) {
				System.out.println(students[i].name);
			}
		}
		
		
		// 6. 단답형
		// : object
		
		// 7. 단답형
		// : size()
		
		// 8. 단답형
		// : 삼항연산자?
		
		// 9.
		// : 4

		// 10.
		// : 2
		
		// 11.
		// : Child
		
		// 12.
		// : 2
		
		// 13.
		// : 2
		
		// 14.
		// : Dog가 Animal 상속받아야함
		
		// 15.
		// : 2
		
		// 16.
		// : 3
		
		// 17.
		// : public
		
		// 18.
		// : 4
		
	}
}
