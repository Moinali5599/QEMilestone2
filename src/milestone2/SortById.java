package milestone2;

import java.util.Comparator;

public class SortById implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.id.compareTo(s2.id);
		
	}

}
