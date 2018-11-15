package toolbox; 

// see https://stackoverflow.com/questions/8798403/string-is-immutable-what-exactly-is-the-meaning

public class StringImmutability {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = s1;
		System.out.println(s2);
		s1 = "Good Bye";
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
