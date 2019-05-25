package toolbox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import auxiliary.Animal;
import auxiliary.Dog;
import auxiliary.Person;


public class Lambdas {
	
	static List<Person> list = new ArrayList<>();
	

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		Person p1 = new Person("Mike", 18);
		Person p2 = new Person("Albert", 19);
				
		
		list.add(p1);
		list.add(p2);		
				
		for (Person p : list) {
			System.out.println(p.getName());
		}
		
		// traditional way
		// Arrays.sort(listp, new ByName());	
		
		//lambda way		
		Collections.sort(list, (person1, person2) -> person1.getName().compareTo(person2.getName()));
		
		for (Person p : list) {
			System.out.println(p.getName());
		}
		
	}
	
	public List<Person> alo() {
		return list;
		
	}
	
	public <T> T spitOut(T obj) {
		return obj;
		
	}
	
}
