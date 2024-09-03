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

public class StudentTest {

    private Student instance;

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       
        instance = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = "10111";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "J.Bloggs";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int expResult = 19;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "jbloggs@ymail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        String expResult = "disd";
        String result = instance.getCourse();
        assertEquals(expResult, result);
    }

    @Test
    public void testDisplayStudent() {
        System.out.println("displayStudent");
        instance.displayStudent();
    }
}
