package chapter09;

import java.io.UncheckedIOException;

// 자바 예외 처리

// 1. 예외(Exception)란?
// : 프로그램 실행 중에 발생할 수 있는 예기치 못한 문제나 조건

// +) 예외 처리
//		: 예외가 발생할 경우 프로그램이 중단되지 않고 대응하여 정상적인 흐름을 유지하는 방법

// 2. 자바 예외 클래스 구조
// - Throwable: 모든 예외와 오류의 최상위 클래스
// >> 모든 예외 클래스는 해당 클래스를 상속받음 (예외와 관련된 메시지, 처리 방법에 대한 예시 정보를 포함)

// cf) 자바 클래스 타입의 최상위 클래스 'Object'

// 자바의 예외와 오류
// 1) Exception(예외) 클래스
// : 프로그램이 처리할 수 있는 예외들을 정의
// > 예외 처리를 통해 '개발자'가 해결할 수 있는 문제들을 정의

// 1-1) Checked Exception
// : 컴파일 시점에 체크되는 예외 (코드 작성 시)
// - 개발자가 직접 반드시 처리
// - 컴파일러는 해당 예외가 처리되어 있지 않을 경우 오류를 발생시킴
class Checked {
	// int number == 10;
}

// 1-2) Unchecked Exception
// : 런타임 시점에 체크되는 예외
// - 개발자의 실수로 발생하는 예외
// - 컴파일러가 강제하지 않음 (체크하지 않음)

class UnChecked {
	int divide() {
		return 10 / 0;
	}
}

// 2) Error(오류) 클래스
// : 프로그램 외부에서 발생하는 시스템 수준 문제
// > 개발자가 직접 처리 X
// ex) 메모리 부족, 네트워크 연결 등

public class Exception01 {
	public static void main(String[] args) {
		
		UnChecked unChecked = new UnChecked();
		// unChecked.divide(); //   / by zero
		
		// cf) 컴파일 시점 vs. 런타임 시점
		// - 컴파일
		//		: 소스 코드를 기계어로 번역하는 단계
		// 			, 실행되지 않고 코드를 분석하고 변환하는 과정만을 국한
		// >> 자바에서는 .java 파일이 컴파일되어 .class 파일(바이트코드)로 생성
		
		// - 런타임
		//		: 컴파일된 프로그램이 실행되는 단계
		// 			, 프로그램이 실제 메모리에 로드되고 CPU에서 실행됨
		// >> 컴파일 시점에 잡히지 않는 논리적 오류, 런타임 예외 발생 가능성이 존재
		
		
	}
}
