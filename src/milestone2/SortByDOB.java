package milestone2;

import java.util.Comparator;

public class SortByDOB implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2){
		return (s1.dob).compareTo(s2.dob);
	}

}
