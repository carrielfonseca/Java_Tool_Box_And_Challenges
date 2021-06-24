package toolbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import auxiliary.Person;

// https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html
// https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
// challenge for the wildcard is when it goes as the argument of a method. The trick is that it never really goes in the new expression.
// The wildcard goes in the receiving end of the variable type


// also interesting: https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/

public class Generics<R> {
	
	static List<Person> list = new ArrayList<>();
	
	// need to cast it like this in order to make an array of parametrized types
	// see https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createArrays
	// and https://algs4.cs.princeton.edu/41graph/Graph.java.html  (on constructor)
	List<String>[] arrayOfLists = (ArrayList<String>[]) new ArrayList[2];
	// List<String>[] arrayOfListsWrong =  new ArrayList<String>[2]; this does not work

	public static void main(String[] args) {	
		// "A wildcard parameterized type is not a concrete type that could appear in a new expression."
		//  in https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/
		List<Number> ls = new ArrayList<>();    //this is right 
		List<? extends Number> ls2 = new ArrayList<Long>();    //this is also right, but now there is no inference typing in the new expression. You have to be explicit
		List<? extends Number> ls3 = new ArrayList<>();    //this is confusing. What is the type of this List?
		//List<Number> ls = new ArrayList<Integer>();    //this is wrong and will give a compile error
		
		Integer n = Integer.valueOf(20);
		Double d = Double.valueOf(20.0);
		ls.add(n);
		ls.add(d);
		
		System.out.println(n instanceof Number);
		System.out.println(n instanceof Integer);		
		
		List<Integer> li = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + sumOfList(li));	
	}
	
///////////////////////////////////////////////////////////////	
	
	// this works
	public static double sumOfList(List<? extends Number> list) {
	    double s = 0.0;
	    for (Number n : list)
	        s += n.doubleValue();
	    return s;
	}
	
	// this does not work
//	public static double sumOfList(List<Number> list) {
//	    double s = 0.0;
//	    for (Number n : list)
//	        s += n.doubleValue();
//	    return s;
//	}
	
///////////////////////////////////////////////////////////////
	
	public <T> T spitOut(T obj) {
		return obj;		
	}
	
	public <T> void spitOut2(T obj) {
		System.out.println(obj);		
	}
	
	// Generic R is already declared at the class level
	public R spitOut3(R obj) {
		return obj;		
	}
}
