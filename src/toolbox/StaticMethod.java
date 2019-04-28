package toolbox;

// when you call a method inside another method in the same class, what you are doing implicitly is
// using the object created to call this method. However, is this method is static, 
// Java will use the method inside as another static (Class reference) method/
// This is the reason it doesn't really work call a non-static method inside a static one:
// Jaca would try to call the method inside as a static reference, which simply does not exist

public class StaticMethod {

	public static void main(String[] args) {
//		sayHello(); // this does not work
		StaticMethod staticMethod = new StaticMethod();
		staticMethod.sayHello(); //This works

	}
	
	private void sayHello() {
		System.out.println("Hello World");;
	}
	

}
