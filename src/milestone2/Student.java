package milestone2;

import java.text.*;
import java.time.*;
import java.util.*;

public class Student {

	String id;
	String name;
	String gender;
	Date dob;
	int age;
	int maleCount = 0;
	int femaleCount = 0;
	DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

	public Student(String id, String name, String gender, String dob) throws ParseException {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = f.parse(dob);
	}

	// public String getId() {
	// return id;
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public String getGender() {
	// return gender;
	// }
	//
	public Date getDOB() {
		return dob;
	}

	public int getStudentAge() {
		Instant instant = dob.toInstant();
		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		LocalDate conv_DOB = zone.toLocalDate();
		Period period = Period.between(conv_DOB, LocalDate.now());
		age = period.getYears();
		return age;
	}

	public void getDetails() {
		System.out.println(id + " " + name + " " + gender + " " + dob);
	}

}
