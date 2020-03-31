package threadTest;

import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터와 가위 바위 보는 난수를 이용하여 구하고
 	사용자의 가위 바위 보는 showInputDialog() 메서드를 이용하여 입력받는다.
 	
 	입력시간은 5초로 제한하고카운트 다운을 진행한다.
 	5초 안에 입력이 없으면 게임을 진 것으로 처리한다.
 	
 	5초 안에 입력이 완료되면 승패를 출력한다.
 	
 	결과 예시) 
 	===== 결과 =====
 	컴퓨터 : 가위
 	당   신 : 바위
 	결   과 : 당신이 이겼습니다.
*/
public class T07_ThreadTest {

	public static boolean Check = false;
	
	public static void main(String[] args) {
		Thread gameInput = new GameDataInput();
		Thread gameTimer = new GameTimer();
		  
		 gameInput.start();
		 gameTimer.start();
	}
}

/**
 * 
 * 데이터를 입력하는 클래스
 *
 */
class GameDataInput extends Thread{
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");

		// 입력이 완료되면 inputCheck변수를 true로 변경한다.
		T07_ThreadTest.Check = true;
		
		int radom = (int) Math.random() * 3;
		
		String computer = null;
		if(radom == 0) {
			computer = "가위";
		} else if (radom == 1) {
			computer = "바위";
		} else {
			computer = "보";
		}
		System.out.println("===== 결과 =====");
		System.out.println("컴퓨터 : " + computer);
		System.out.println("당   신 : " + str);
		
		if(computer.equals(str)) {
			System.out.println("비겼습니다.");
		}else if (computer.equals("바위") && str.equals("보") 
				|| computer.equals("가위") && str.equals("바위") 
				|| computer.equals("보") && str.equals("가위") ) {
			System.out.println("결과 : 당신이 이겼습니다.");
		} else {
			System.out.println("컴퓨터가 이겼습니다.");
		}
	}
}


/**
 * 카운트 다운을 처리하는 쓰레드 클래스
 */
class GameTimer extends Thread{
	
	@Override
	public void run() {
	      for(int i = 5; i >= 0; i--) {
	          //입력이 완료되었는지 여부를 검사하고 입력이 완료되면
	          //run()메서드를 종료시킨다. 즉, 현재 쓰레드를 종료 시킨다.
	          if(T07_ThreadTest.Check) {
	             return; //run()메서드가 종료되면 쓰레드도 끝난다.
	          }
	          System.out.println(i);
	          try {
	             Thread.sleep(1000);
	          }catch(InterruptedException e) {
	             e.printStackTrace();
	          }
	       }
	       //5초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
	       System.out.println("5초가 지났습니다. 프로그램을 종료합니다.");
	       System.exit(0);   //프로그램을 종료시키는 명령
	    }
}
