package annotationTest.test;

import annotationTest.annotation.PrintAnnotation;

public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	
	@PrintAnnotation("%") // value="#" 밑에처럼 명시해 줘야 하지만 타입요소의 이름이 value이면 명시 해주지 않고도 가능 하다.혼자이면 간으 다른 타입이름과 같이 써야할때도 안된다.
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value="#", count = 25)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}
