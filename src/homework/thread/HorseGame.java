package homework.thread;

public class HorseGame {
	static int horseRank = 1;
	static HorseVO[] horse = new HorseVO[10];
	public static void main(String[] args) {

		

		for (int i = 0; i < horse.length; i++) {
			horse[i] = new HorseVO(i + 1 + "마");
		}// 말의 객체를 만드는 중
		
		printCurrentHorsePosition dis = new printCurrentHorsePosition();
		dis.start();
		
		for (int i = 0; i < horse.length; i++) {
			horse[i].start();
		}

	}// main

}// HorseGame

// 말에 대한 정보 및 클래스
class HorseVO extends Thread implements Comparable<HorseVO>{

	private String horseName;
	private int position; // 말의 위치
	private int rank; // 말이 들어온 순서
	private boolean goal;

	public HorseVO() {

	}

	public HorseVO(String horseName) { // 생성자에서 초기화
		this.horseName = horseName;
		position = 0; // 말의 위치
		rank = 1; // 말이 들어온 순서
		goal = false;
	}

	@Override
	public void run() {

			for (int i = 0; i < 50; i++) {

				try {
					sleep((int) (Math.random() * 300)); // 말들의 속도를 다르게 하기 위해서

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setPosition(i); // 말 위치 이동

			}// for
			setGoal(true); // 도착
			rank = HorseGame.horseRank++;
			


	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isGoal() {
		return goal;
	}

	public void setGoal(boolean goal) {
		this.goal = goal;
	}

	public String getHorseName() {
		return horseName;
	}

	@Override
	public int compareTo(HorseVO o) {
		// TODO Auto-generated method stub
		return Integer.compare(rank, o.getRank());
	}

}

class printCurrentHorsePosition extends Thread{
	
	HorseVO hVO = new HorseVO();
	
	public void clear() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}//clear
	
	public void horseLocation() {
		for (int i = 0; i < HorseGame.horse.length; i++) {//각각의 말
			for (int j = 0; j < 50; j++) {
				if(j == HorseGame.horse[i].getPosition()) {//말의 위치
					System.out.print(">");
				}else {
					System.out.print("-");
				}
				
			}//for j
			System.out.print("     " + (i+1) +"번말" +"의 순위 : " + HorseGame.horse[i].getRank());
			
			System.out.println();
			
		}//for i
	}//horseLocation
	
	@Override
	public void run() {
		
		while(true) {
		clear();
		horseLocation();
		
		if(11 == HorseGame.horseRank) {
			
			System.out.println("게임이 종료되었습니다.");
			return;
		}
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}//while
	}//run
	
	
	
}
