package homework.thread;

public class HorseGame {

	public static void main(String[] args) {
		
			HorseVO[] horse = new HorseVO[10];
			
			for (int i = 0; i < horse.length; i++) {
				horse[i] = new HorseVO(i+1 +"번째말");
			}
		
		


	}//main

}//HorseGame

// 말에 대한 정보 및 클래스
class HorseVO extends Thread implements Comparable<HorseVO>{
	private String horseName;
	private String 

	public HorseVO() {
		
	}
	
	public HorseVO(String horseName) {
		this.horseName = horseName;
	}
	@Override
	public int compareTo(HorseVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
