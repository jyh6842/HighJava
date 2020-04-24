package lamdaTest;
/*
	람다식 => 익명함수를 생성하기 위한 식
			자바에서는 '매개변수를 가진 코드 블럭'
			=> 런타임시 => 익명구현 객체로 생성한다.
			
	형식 ) 인터페이스명 = 람다식;
	람다식의 형식) (매겨변수들...) -> {처리할 코드들;...}
	
	=> 람다식으로 변환할 수 잇는 인터페이스는 추상메서드가 1개인
		인터페이스만 처리할 수 있다.
		이런 인터페이스를 '함수적 인터페이스'라고 한다.
		이 함수적 인터페이스를 만들 대는 @FunctionalInterface 로 지정한다.
	
*/
public class T01_LambdaTest { // 794
	public static void main(String[] args) {
		// 람다식을 사용하지 않을 경우
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() { // 추상 메서드가 하나라서 자동 완성이 되는 것 이런 인터페이스를 함수형 인터페이스라고 부르고 이러한 것을 람다식을 바꿀 수 있다.
				for(int i = 1; i<= 10; i++) {
					System.out.println(i);
				}
			}
		});
		th1.start();
		
		// 람다식을 사용할 경우...
		Thread th2 = new Thread(() -> {
			for(int i = 1; i<= 10; i++) {
				System.out.println("람다-" + i);
			}
			
		}); 
		th2.start();
		
	}
}
