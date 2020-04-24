package lamdaTest;
/*
	함수적 인터페이스 -> 추상메서드가 1개가 선언된 인터페이스
*/
@FunctionalInterface
public interface LambdaTestInterface1 {
	// 반환값이 없고 매개변수도 없는 추상메서드 선언
	
	public void test();
//	public void test2(); //추상인터페이스가 아니고 추상 메서드가 아니다.
	// 2 개가 들어가면 functionalInterface가 아니다.
}
@FunctionalInterface
interface LambdaTestInterface2 {
	// 반환값이 없고 매개변수가 잇는 추상 메서드 선언
	public void test(int a);
}
@FunctionalInterface
interface LambdaTestInterface3 {
	// 반환값이 있고 매개변수도 잇는 추상 메서드 선언
	public int test(int a, int b);
}
