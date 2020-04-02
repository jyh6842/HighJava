package threadTest;

public class T15_SyncThreadTest { // 동기화
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번 쓰레드", sObj);
		WorkerThread th2 = new WorkerThread("2번 쓰레드", sObj);
		
		th1.start();
		th2.start();
		
		
	}
}

// 공통으로 사용할 객체
class ShareObject {
	private int sum = 0;
	// p767
	

	/*	
	// 동기화 하는 방법1 : 메서드 자체에 동기화 설정하기
	public synchronized void add() {
	int n = sum;
	n += 10;
	sum = n;	
	
	}
	/----------------------------------------
	*/
	
	// 동기화 하는 방법 2 : 동기화 블럭으로 설정-----
	public void add() {
		
		
		synchronized (this) {
			int n = sum;
			n += 10;
			sum = n;
		}
		
	//-----------------------------------	
		System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
	}
	
	public int getSum() {
		return sum;
	}
	

}

class WorkerThread extends Thread{
	ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
		}
	}
}

