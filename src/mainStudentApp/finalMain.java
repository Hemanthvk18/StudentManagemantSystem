package mainStudentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class finalMain {
	static ArrayList<Student> studentList;
	static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*** Welcome to Student Management System ***");
		studentList = new ArrayList<Student>();
		while (true) {
			System.out.println("-------------------------------------------------");
			System.out.println("Select the below options....");
			System.out.println("1. Rigister the student");
			System.out.println("2. List of all the student");
			System.out.println("3. List of all the student in sorted order");
			System.out.println("4. find the student by studentID");
			System.out.println("5. Exit");

			scanner = new Scanner(System.in);
			int options = scanner.nextInt();

			switch (options) {
			case 1:
				enrollStudent(scanner);
				break;

			case 2:
				allStudents();
				break;

			case 3:
				sortByName();
				break;
			case 4:
				findStudentById(scanner);
				break;
			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid option enterd....!");

			}
		}

	}

	private static void findStudentById(Scanner scanner2) {

		String studentId = scanner2.next();
		Student studentFound = null; // explicit initialization , default null because primitive datatype
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found");
		}
		studentFound.printStudentInfo();

	}

	private static void enrollStudent(Scanner scanner2) {

		System.out.println("Enter the student Name:");
		String studentName = scanner2.next();

		System.out.println("Enter the student Age (Between 19-30):");
		int studentAge = scanner2.nextInt();

		System.out.println("Enter the student StudentID (Ex:- S-123):");
		String studentID = scanner2.next();

		Student newStudent = new Student(studentName, studentAge, studentID);
		studentList.add(newStudent);

		while (true) // if we dont know the loop end , then go with while loop
		{
			System.out.println("Enter the course to be enrolled... || Type 'Done' to exit");
			String courses = scanner2.next();
			if (courses.equalsIgnoreCase("done")) {
				break; // break the loop
			}
			newStudent.enrollCourse(courses);
		}
		newStudent.printStudentInfo();

	}

	private static void allStudents() {
		if (studentList.size() > 0) {
			System.out.println("========== Printing all student information ==========");
			for (Student student : studentList) {
				student.printStudentInfo();
			}
		} else {
			System.err.println("Student list is empty..!! No record found");
		}
		System.out.println("------------------------------------------------------");

	}

	private static void exit() {
		System.out.println("Thank you reaching out the 'Student Management System' application:- HAVE A GOOD DAY");
		System.exit(0);

	}

	public static Student findStudentId(String studentId) {
		Student result = null; // explicit initialization , default null because primitive datatype
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found");
		}

		return result;
	}

	public static void sortByName() {

		if (studentList.size() > 0) {
			System.out.println("---------------- Student name in soreted order :----------------");

			Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName()); // Lambda expression to reduce the code
																										

			/*
			 * Comparator<Student> studentNameComparator=new Comparator<Student>() {
			 * 
			 * @Override public int compare(Student o1, Student o2) {
			 * 
			 * return o1.getName().compareTo(o2.getName()); // compare lexograhically }
			 * 
			 * };
			 */

			Collections.sort(studentList, studentNameComparator);
			System.out.println(studentList);
		} else {
			System.err.println("Student list is empty..!! No record found");
		}
	}

}
