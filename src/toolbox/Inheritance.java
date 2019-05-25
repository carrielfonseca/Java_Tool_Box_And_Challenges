package toolbox;
import java.util.ArrayList;
import java.util.List;

import auxiliary.Animal;
import auxiliary.Dog;
import auxiliary.Person;


public class Inheritance {
	
	public static void main(String[] args) {
	
		Animal an = new Dog();
				
		System.out.println(an.getClass().getName());		
		System.out.println(an instanceof Animal);
		System.out.println(an instanceof Dog);

	}
	
}
