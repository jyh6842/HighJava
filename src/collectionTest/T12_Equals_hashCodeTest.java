package collectionTest;

import java.util.HashSet;
import java.util.Set;

//p634
public class T12_Equals_hashCodeTest {
/*
	HashSet, HashMap, Hashtable과 가틍ㄴ 객체들을 사용할 경우,
	객체가 서로 같은지를 비교하기위해 equals() 메서드와 hashCode() 메서드를 호출한다.
	그래서, 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야한다.
	HashSet, HashMap, Hashtable에서는 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	
	- equals() 메서드는 두 객체의 내용(값)이 같은지 비교하는 메서드이고, 
	- hashCode() 메서드는 두 객체가 같은 객체인지를 비교하는 메서드 이다.
	
	- equals()메서드와 hashCode()메서드에 관련된 규칙
	1. 두 객체가 같으면 반드시 같은 hashCode를 가져야 한다.
	2. 두 객체가 같으면 equals() 메서드를 호출 햇을 때 true를 반환해야 한다.
		즉, 객체 a, b 가 같다면 a. equals(b) 와 b.equals(a) 둘다 true 이어야 한다.
	3. 두 객체의 hashcode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
		하지만, 두객체가 같으면 반드시 hashcode가 같아야 한다.
	4. equals() 메서드를 override 하면 반드시 hashCode() 메서드도 override 해야 한다.
	5. hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로 한 정수값을 반환한다.
		그러므로 , 클래스에서 hashCode()메서드를 override 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
		
	- hashCode() 메서드에서 사용하는 '해싱 알고리즘'에서 서로 다른 객체에 대하여 같은 
	  hashCode 값을 만들어낼 수 있다. 
	    그래서 객체가 같지 않더라고 hashCode가 같을 수 있다.
 */
	public static void main(String[] args) {
		Person p1 = new Person(1,"홍길동");
		Person p2 = new Person(1,"홍길동");
		Person p3 = new Person(1,"이순신");
		
		// 해쉬코드가 있어야 객체가 달라도 중복된 값을 넣지 않도록 할 수 있다. 
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1==p2)); //p1 == p1 이면 자기자신 객체라서 true
		
		Set<Person> set = new HashSet<>();
		
		set.add(p1);
		set.add(p2);
		
		System.out.println("p1, p2 등록 후 데이터...");
		for(Person p : set) {
			System.out.println(p1.getId() + " : " + p.getName());
		}
		
		System.out.println("add(p3) 성공여부 : " + set.add(p3));
		System.out.println("add(p3) 후 데이터...");
		for (Person p : set) {
			System.out.println(p1.getId() + " : " + p.getName());
		}
		
		System.out.println("remove(p2) 성공여부 : " + set.remove(p2));
		System.out.println("remove(p2) 성공 후 데이터..." );
		for (Person p : set) {
			System.out.println(p1.getId() + " : " + p.getName());
		}

	}


}


class Person{
	int id;
	String name;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
