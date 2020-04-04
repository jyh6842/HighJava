package threadTest;

/*
 	wait() 메서드 -> 동기화 영역에서 lock 를 들고 Wait - Set 영역 ( 공유 객체별 존재 ) 으로 이동 시킨다.
 	notify() or notifyAll() 메서드 => Wait-Set 영역에 잇는 쓰레드를 깨워서 실행될 수 있도록 한다.
 									(notify()는 1개, notifyAll()은 Wait-Set에 잇는 전부를 깨운다)
 						=> wait() 와 notify(), notifyAll() 메서드는 동기화 영역에서만 실행 할 수 있고,
 							Object 클래스에서 제공하는 메서드 이다.
*/
public class T19_WaitNotifyTest {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}
}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA() 메서드 작업 중...");
		
		notify(); // 공유 객체 사용할 methodB 일어나
		
		try {
			wait(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//methodA
		public synchronized void methodB() {
			System.out.println("methodB() 메서드 작업 중...");
			
			notify(); // 나를 깨우는게 아니라 wait set 장소에 있는 잠들어 있는 애들을 깨우는 것(랜덤으로 깨움)
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// methodB
	
}// WorkObject

class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObj.methodA();
		}
		System.out.println("ThreadA 종료");
	}
}

class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObj.methodB();
		}
		System.out.println("ThreadB 종료");
	}
}
