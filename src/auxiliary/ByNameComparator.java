package auxiliary;
import java.util.Comparator;

public class ByNameComparator implements Comparator<Person> {

	
	@Override
	public int compare(Person person1, Person person2) {
		if (person1.getName().compareTo(person2.getName()) < 0) {
			return -1;
		} else if (person1.getName().compareTo(person2.getName()) < 0) {
			return 1;
		} else {
			return 0;
		}

	}
}
