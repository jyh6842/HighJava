package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
  	문제) 학번, 이름, 국어점수, 영어점수, 수학 점수, 총점, 등수를 멤버변수로 갖는 Student 클래스를 만든다.
   		생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
   		이 Studnet 객체들은 List에 저장하여 관리한다.
   		List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
   		총점의 역순으로 정렬하는 부분을 프로그램 하시오.
   		(총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
   		(학번의 정렬기준은 Student 클래스 자체에서 제공하도록 하고,
    	총점 정렬기준은 외부클래스에서 제공하도록 한다.)	
*/
public class T08_StudnetTest {

	public static void main(String[] args) {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		
		studentList.add(new StudentVO("1000", "김씨", 40, 50, 60));
		studentList.add(new StudentVO("1001", "박씨", 50, 60, 70));
		studentList.add(new StudentVO("1005", "최씨", 60, 80, 90));
		studentList.add(new StudentVO("1006", "이씨", 70, 50, 60));
		studentList.add(new StudentVO("1004", "양씨", 80, 70, 60));
		studentList.add(new StudentVO("1002", "심씨", 90, 50, 70));
		studentList.add(new StudentVO("1003", "임씨", 100, 50, 60));
		
		for(StudentVO SVO : studentList) {
			System.out.println(SVO);
		}
		System.out.println("======================================");
		
		System.out.println("학번의 오름차순으로 정렬하여 출력");
		Collections.sort(studentList);// 정렬
		
		for(StudentVO SVO : studentList) {
			System.out.println(SVO);
		}
		System.out.println("==============================");
		System.out.println("섞기");
		Collections.shuffle(studentList);
		for(StudentVO SVO : studentList) {
			System.out.println(SVO);
		}
		
		System.out.println("=============================");
		System.out.println("총점의 역순으로 큰 수부터 나오도록 출력");
		Collections.sort(studentList, new SortTotalDesc());
		



		for (int i = 0; i < studentList.size(); i++) {
			studentList.get(i).setRank(1);
			for (int j = 0; j < studentList.size(); j++) {
				if(studentList.get(i).getTotal() < studentList.get(j).getTotal()) {
					studentList.get(i).setRank(studentList.get(i).getRank()+1);

				}

			}

			
			

		}
		
		for(StudentVO SVO : studentList) {
			
			System.out.println(SVO);
		}
		
		
		
	}

}

class SortTotalDesc implements Comparator<StudentVO>{

	@Override
	public int compare(StudentVO st1, StudentVO st2) {
		if((st1.getTotal() > st2.getTotal() ) ) {
			return -1;
		}else if((st1.getTotal() == st2.getTotal())) {
			
			if ((Integer.parseInt(st1.getStudnetNum()) > Integer.parseInt(st2.getStudnetNum()))) {
				return -1;
			}else if((Integer.parseInt(st1.getStudnetNum()) == Integer.parseInt(st2.getStudnetNum()))) {
				return 0;
			}else {
				return 1;
			}
			
		}else {
			return 1;
		}
		
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법1
		// 내림차순일 경우에는 -1을 곱해준다.
		//return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;.
		
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법2
//		return new Integer(st1.getTotal()).compareTo(st2.getTotal()) * -1;
		
	}
	
}

class StudentVO implements Comparable<StudentVO>{
	String studnetNum;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	int rank;

	public StudentVO(String studnetNum, String name, int kor, int eng, int math) {
		super();
		this.studnetNum = studnetNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	}

	public String getStudnetNum() {
		return studnetNum;
	}

	public void setStudnetNum(String studnetNum) {
		this.studnetNum = studnetNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "StudentVO [studnetNum=" + studnetNum + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", total=" + total + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(StudentVO mem) {
		return getStudnetNum().compareTo(mem.getStudnetNum());
		
	}

}
