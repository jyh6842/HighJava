package GenericEnumTest;
//p670
/*
 	제너릭 클래스를 만드는 방법
 	형식)
 	class 클래스명 <제너릭타입글자>{
 		제너릭타입글자 변수명; // 변수선언에서 사용할 경우
 		
 		제너릭 타입글자 메서드명() {
 			return 값;
 		}
 	}
 	
 	
 	--- 제너릭 타입글자 --- 
 	T => Type;
 	K => Key;
 	V => Value;
 	E => Element(자료구조에 들어가는 것들을 나타낼 때 사용)
 */

// 제네릭이 없었을 때
class NonGenericClass {

	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

// 제네릭을 사용한다면
class MyGeneric<T> { // 들어올 변수한테 T라는 타입인데 사용할 때 무슨 타입이라고 알려주는 것type으로 알고 있으면 돼
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}

public class T03_GenericTest {

	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");

		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);

		String rtnNg1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 => " + rtnNg1);

		Integer irtnNg2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 irtnNg2 => " + irtnNg2);

		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();

		mg1.setVal("우리나라");
		mg2.setVal(500);

		rtnNg1 = mg1.getVal();
		irtnNg2 = mg2.getVal();

		System.out.println("제너릭 문자열 반환값 : " + rtnNg1);
		System.out.println("제너릭 정수형 반환값 : " + irtnNg2);

	}
}