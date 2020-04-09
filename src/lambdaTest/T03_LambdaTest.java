package lambdaTest;

public class T03_LambdaTest {
   static int stVar = 9;
   
   public void testMethod(final int temp) { // 매개변수가 지역 변수 이면 final만 매개변수로 들어올 수 있다.
      final int localVar = 50; // 안 붙여도 final
      int kor = 100; // 안붙여도 final
      
      /*
	         람다식 내부에서 사용되는 지역변수는 모두 final이여야 한다.
	         보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
	         단, 지역변수의 값을 변경하는 식이 있을 경우에는 자동으로
	         final을 붙여주지 않는다.
       */
      
      // temp = 500;
      // local = 2000;
      kor = 400;
      
      //람다식에서 지역변수 사용하기
      LambdaTestInterface1 lt = 
            () -> {
               System.out.println("temp =" + temp);
               System.out.println("localVar = " + localVar);
               // System.out.println("kor = " + kor);
               System.out.println("stVar = " + stVar);
               }; 
         lt.test();
   }
   public static void main(String[] args) {
      new T03_LambdaTest().testMethod(200);
   }
}