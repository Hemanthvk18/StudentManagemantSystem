package mainStudentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super(); // call parent
		if (ageValidation(age) && nameValidation(name) && studentIdValidation(studentId)) {
			this.name = name; // diff bw local and instance variable
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();  // Initialization of courses
		} 
	}

	public void enrollCourse(String course) {
		if (validCourses(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to " + course + " course successfully ");
			} else {
				System.err.println("Student is already enrolled the " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("****** Student Information ******");
		System.out.println("Student name: " + name);
		System.out.println("Student age: " + age);
		System.out.println("Student studentId: " + studentId);
		System.out.println("Student courses: " + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "";
	}

	// age validation
	public boolean ageValidation(int age) {
		if (age >= 19 && age <= 30) {
			return true;
		} else {
			System.err.println("Invalid age...!! Student age btween 19 to 30");
			return false;
		}
	}

	public boolean nameValidation(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$"; // allow all char and space. ^- start ,$-end , +- N number of combination
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name format!! , Please enter alphabets only");
			return false;
		}
	}

	public boolean studentIdValidation(String studentId2) {
		String Id = "S-\\d+$"; // S-[0-9]+$
		Pattern idPattern = Pattern.compile(Id);
		Matcher idmatcher = idPattern.matcher(studentId2);
		if (idmatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid ID format!! , Its allows only digits starting with S-.For example (S-123)");
			return false;
		}

	}

	public boolean validCourses(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("Selenium") || course.equalsIgnoreCase("Postman")
				|| course.equalsIgnoreCase("RestAssured")) {
			return true;
		} else {
			System.err.println("Invalid course name: " + course
					+ " , Plase select the courses form this list [Java,Selenium,Postman,RestAssured]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
