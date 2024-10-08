package studentmanagementapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
 *
 * @author WiehanSmit ST10446545@vcconnect.edu.za ST10446545
 */ 

public class StudentManagementApplicationTest {

    public StudentManagementApplicationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
       
    }

    @Before
    public void setUp() {
        StudentManagementApplication.studentList.clear(); 
    }

    @After
    public void tearDown() {
        
    }

    @Test
    public void testSaveStudent() {
        System.out.println("saveStudent");
        String id = "10111";
        String name = "J.Bloggs";
        int age = 19;
        String email = "jbloggs@ymail.com";
        String course = "disd";

        StudentManagementApplication.saveStudent(id, name, age, email, course);

        assertEquals(1, StudentManagementApplication.studentList.size());
        assertEquals(id, StudentManagementApplication.studentList.get(0).getId());
    }

    @Test
    public void testSearchStudent() {
        System.out.println("searchStudent");
        String id = "10111";
        Student student = new Student(id, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        StudentManagementApplication.studentList.add(student);

        Student result = StudentManagementApplication.searchStudent(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        System.out.println("searchStudent_StudentNotFound");
        Student result = StudentManagementApplication.searchStudent("99999");
        assertNull(result);
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("deleteStudent");
        String id = "10111";
        Student student = new Student(id, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        StudentManagementApplication.studentList.add(student);

        boolean isDeleted = StudentManagementApplication.deleteStudent(id);
        assertTrue(isDeleted);
        assertEquals(0, StudentManagementApplication.studentList.size());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        System.out.println("deleteStudent_StudentNotFound");
        boolean isDeleted = StudentManagementApplication.deleteStudent("99999");
        assertFalse(isDeleted);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        System.out.println("studentAge_StudentAgeValid");
        boolean isValid = StudentManagementApplication.validateStudentAge("18");
        assertTrue(isValid);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        System.out.println("studentAge_StudentAgeInvalid");
        boolean isValid = StudentManagementApplication.validateStudentAge("15");
        assertFalse(isValid);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        System.out.println("studentAge_StudentAgeInvalidCharacter");
        boolean isValid = StudentManagementApplication.validateStudentAge("abc");
        assertFalse(isValid);
    }
}
