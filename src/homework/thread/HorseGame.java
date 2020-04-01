package homework.thread;

public class HorseGame {
	
	static String horseNumber[] = new String[10];

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			horseNumber[i] = i+1 +"번말";
		}
		Horse[] horse = new Horse[] {
				new Horse(horseNumber[0]),
				new Horse(horseNumber[1]),
				new Horse(horseNumber[2]),
				new Horse(horseNumber[3]),
				new Horse(horseNumber[4]),
				new Horse(horseNumber[5]),
				new Horse(horseNumber[6]),
				new Horse(horseNumber[7]),
				new Horse(horseNumber[8]),
				new Horse(horseNumber[9])
		};
		
		for(int i = 0; i < horse.length; i++) {
			horse[i].start();
			
	      }
	      
	      for(Horse hs : horse) {
	         try {
	            hs.join();
	         }catch(InterruptedException e) {
	            e.printStackTrace();
	         }
	      }


	}//main

}//HorseGame

class Horse extends Thread{
	private String name;
	private String initHorse[] = new String[50];
	
	Horse(String name) {
		this.name = name;
		initHorse[0]=">";
		for (int i = 1; i < initHorse.length; i++) {
			initHorse[i] ="-";
		}
	}
	
	@Override
	public void run() {

		for (int i = 0; i < initHorse.length; i++) {
			System.out.print(initHorse[i]);
		}//for

		System.out.println();
		
		for (int i = 0; i < initHorse.length-1; i++) {
			
		try {
            Thread.sleep((int)(Math.random()*301 + 200));
         }catch(InterruptedException e) {
            e.printStackTrace();
         }

		
			String temp = initHorse[i];
			initHorse[i] = initHorse[i+1];
			initHorse[i+1] = temp;
			display();
			
			clear();
		}//for
		System.out.println();
	}//run
	
	public void clear() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	public void display() {
		System.out.println(HorseGame.horseNumber[0]);
		System.out.println(HorseGame.horseNumber[1]);
		System.out.println(HorseGame.horseNumber[2]);
		System.out.println(HorseGame.horseNumber[3]);
		System.out.println(HorseGame.horseNumber[4]);
		System.out.println(HorseGame.horseNumber[5]);
		System.out.println(HorseGame.horseNumber[6]);
		System.out.println(HorseGame.horseNumber[7]);
		System.out.println(HorseGame.horseNumber[8]);
		System.out.println(HorseGame.horseNumber[9]);
	}
	
}
