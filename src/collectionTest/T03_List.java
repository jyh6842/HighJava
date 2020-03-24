package collectionTest;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class T03_List {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(0, 123);
		list.add(1, 456);
		list.add(2, 789);
		System.out.println(list);
		
		List list2 = new ArrayList();
		list2.add(0, "가");
		list2.add(1, "나");
		list2.add(2, "다");
		list.addAll(2, list2);
		System.out.println(list);
		System.out.println("==========");
		//2.
		System.out.println(list.get(2));
		System.out.println("==========");
		//3.
		System.out.println(list.indexOf("가"));
		System.out.println("==========");
		//4.
		System.out.println(list.lastIndexOf("다"));
		System.out.println("==========");
		//5.
		
		//6.
		System.out.println(list.remove(0));
		System.out.println(list);
		//7.
		list.set(2, "라");
		System.out.println(list);
		//8.
//		list.sort(Comparator.naturalOrder());
//		System.out.println(list);
		//9.
		List list3 = new ArrayList();
		
		list3 = list.subList(0, 2);//0,1
		System.out.println(list3);
		
		
		
	}
}
