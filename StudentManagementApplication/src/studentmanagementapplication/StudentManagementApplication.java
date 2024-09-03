package studentmanagementapplication;

import java.util.ArrayList;
import java.util.Scanner;

/** 
 *
 * @author WiehanSmit ST10446545@vcconnect.edu.za ST10446545
 */ 
//Student class
class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;
//------------------------------------------------------------------------------
    // Custom Constructor
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
    //--------------------------------------------------------------------------
    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
//------------------------------------------------------------------------------
    // Display student details
    public void displayStudent() {
        System.out.println("STUDENT ID: " + id);
        System.out.println("STUDENT NAME: " + name);
        System.out.println("STUDENT AGE: " + age);
        System.out.println("STUDENT EMAIL: " + email);
        System.out.println("STUDENT COURSE: " + course);
        System.out.println("------------------------------");
    }
}
//------------------------------------------------------------------------------
//Main Class
public class StudentManagementApplication 

{
    public static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("******************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("Exiting Application.");
                break;
            }

            displayMenu();
        }
    }
    //--------------------------------------------------------------------------
    //Displays Student menu if the user presses (1)
    private static void displayMenu() 
    {
        while (true) {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureStudent();  //captures a new student
                    break;
                case "2":
                    handleSearchStudent(); //searching for a student
                    break;
                case "3":
                    handleDeleteStudent(); //deleting a student
                    break;
                case "4":
                    printStudentReport(); //prints the student report
                    break;
                case "5":
                    System.out.println("Exiting Application.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
//------------------------------------------------------------------------------
    //Capturing a new student in the memory
    public static void captureStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("**********************");

        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter the student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 16) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
            }
        }

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        saveStudent(id, name, age, email, course);
        System.out.println("Student details have been successfully saved.");
    }
    //--------------------------------------------------------------------------
    //Searching for the Student ID that is captred in memory
    private static void handleSearchStudent() {
        System.out.print("Enter the student id to search: ");
        String id = scanner.nextLine();
        Student student = searchStudent(id);
        if (student != null) {
            student.displayStudent();
        } else {
            System.out.println("Student with Student Id: " + id + " was not found!");
        }
    }
    //--------------------------------------------------------------------------
    //Method that checks the ID from user input, if found then "was deleted!", if not "was not found!"
    private static void handleDeleteStudent() {
        System.out.print("Enter the student id to delete: ");
        String id = scanner.nextLine();
        boolean isDeleted = deleteStudent(id);
        if (isDeleted) {
            System.out.println("Student with Student Id: " + id + " was deleted!");
        } else {
            System.out.println("Student with Student Id: " + id + " was not found!");
        }
    }
//------------------------------------------------------------------------------
    public static void saveStudent(String id, String name, int age, String email, String course) 
    {
        studentList.add(new Student(id, name, age, email, course));
    }
    //--------------------------------------------------------------------------
    //Method to search Students through theire ID
    public static Student searchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------
    //Method to delete Student
    public static boolean deleteStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }
    //--------------------------------------------------------------------------
    //Method to print all Studdents that was saved
    public static void printStudentReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("****************");

        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            int studentNumber = 1;
            for (Student student : studentList) {
                System.out.println("STUDENT " + studentNumber++);
                student.displayStudent();
            }
        }
    }
    //--------------------------------------------------------------------------
    //Method to validate the students age
    public static boolean validateStudentAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            return age >= 16;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
//----------------------------- End of File ------------------------------------
