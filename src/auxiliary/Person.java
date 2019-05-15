package auxiliary;
import java.util.Comparator;

public class Person implements Comparator<Person> {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compare(Person person1, Person person2) {
		if (person1.name.compareTo(person2.name) > 0) {
			return 1;
		} else if (person1.name.compareTo(person2.name) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
