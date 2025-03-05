package chapter03;

public class B_Array {

	public static void main(String[] args) {
		// 배열의 순회
		int[] scores = {85, 100, 95, 70, 90};
		System.out.println("== 인덱스 번호로 출력 ==");
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]);
		System.out.println(scores[4]);
		
		// for 반복문을 사용해서 점수를 순서대로 출력
		System.out.println("== for문을 사용하여 출력 ==");
		
		int scoresLength = scores.length;
		
		for(int i = 0; i < scoresLength; i++) {
			System.out.println(scores[i]);
		}

		// 향상된 for 
		// : 배열을 순회(탐색)하는 방법
		// - for문의 간결한 형태
		
		/*
		 	for (데이터타입 변수명: 해당 데이터타입의 배열) {
		 		배열의 각 요소를 활용하는 코드
		 	}
		 */
		
		System.out.println("== 향상된 for문을 사용한 출력 ==");
		// for-each문
		for (int score: scores) {
			// score 변수의 값은 for문의 반복에서 배열의 요소를 순차적으로 담는 변수
			System.out.println(score);
		}
		
		// 배열 예제
		// 학생 점수의 평균 계산
		// : 점수를 모두 더해서 점수의 개수만큼 나누기
		
		int total = 0;
		int length = scores.length;
//		
//		for (int i = 0; i < length; i++) {
//			total += scores[i];
//		}
		
		
		
		// for-each 사용
		
		for(int score: scores) {
			total += score;
		}
		
		double average = total / length;
		
		System.out.println("평균 점수: " + average);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
