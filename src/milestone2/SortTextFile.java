package milestone2;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class SortTextFile{

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		int choice;
		int ageCount=0;
		int maleCount=0;
		int femaleCount=0;
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<Student> students = new ArrayList<Student>();
		FileInputStream fis = new FileInputStream("data.txt");
		Scanner sc = new Scanner(fis);
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		sc.close();
		for (String line : lines) {

			String[] details = line.split(",");
			students.add(new Student(details[0], details[1], details[2],details[3]));
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("1.Sort students by id");
		System.out.println("2.Sort students by name");
		System.out.println("3.Sort students by date of birth");
		System.out.println("4.Get count of students below certian age");
		System.out.println("5.Get count of male students");
		System.out.println("6.Get count of female students");
		choice=s.nextInt();
		
		switch(choice) {
		case 1:
			Collections.sort(students, new SortById());
			for(Student student:students) {
				student.getDetails();
			}
			break;
		case 2:
			Collections.sort(students, new SortByName());
			for(Student student:students) {
				student.getDetails();
			}
			break;
		case 3:
			Collections.sort(students, new SortByDOB());
			for(Student student:students) {
				student.getDetails();
			}
			break;
		case 4:
			int age;
			System.out.println("Enter the age for check: ");
			age=s.nextInt();
			for(Student student:students) {
				if(student.getStudentAge() < age) {
					ageCount++;
				}
			}
			System.out.println("Count of students below "+age+" years: "+ageCount);
			break;
		case 5:
			for(Student student:students) {
				if((student.gender).equalsIgnoreCase("M")) {
					maleCount++;
				}
			}
			System.out.println("Number of male students: "+maleCount);
			break;
		case 6:
			for(Student student:students) {
				if((student.gender).equalsIgnoreCase("F")) {
					femaleCount++;
				}
			}
			System.out.println("Number of female students: "+femaleCount);
			break;
		}
		s.close();
	}

}
