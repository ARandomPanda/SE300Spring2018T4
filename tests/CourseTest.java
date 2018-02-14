import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course testA;
    Course testB;
    Course testC;

    @Test
    void testConstructor() {
        Course a = new Course("AA 101", "TestA", 0);
        Course b = new Course("BB 101", "TestB", 6);
        Course c = new Course("CC 101", "TestC", 3);
        assertThrows(NullPointerException.class,
                () -> new Course(null, "Test", 0));
        assertThrows(NullPointerException.class,
                () -> new Course("Test", null, 0));
        assertThrows(NullPointerException.class,
                () -> new Course(null, null, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new Course("a", "b", -1));
        assertThrows(IllegalArgumentException.class,
                () -> new Course("a", "b", 7));
    }

    @BeforeEach
    void makeTestCourse() {
        testA = new Course("AA 101", "TestA", 0);
        testB = new Course("BB 101", "TestB", 3);
        testC = new Course("CC 101", "TestC", 6);
    }

    @Test
    void setNumCredits() {
        testA.setNumCredits(1);
        assertEquals(1, testA.getNumCredits());
        testB.setNumCredits(2);
        assertEquals(2, testB.getNumCredits());
        testC.setNumCredits(5);
        assertEquals(5, testC.getNumCredits());
        assertThrows(IllegalArgumentException.class,
                () -> testA.setNumCredits(-1));
        assertThrows(IllegalArgumentException.class,
                () -> testA.setNumCredits(7));
    }

    @Test
    void setGrade() {
        assertTrue(Grade.NONE == testA.getGrade());
        testA.setGrade(Grade.A);
        assertTrue(Grade.A == testA.getGrade());
        assertTrue(testA.isAttempted());
        testA.setGrade(Grade.NONE);
        assertFalse(testA.isAttempted());
    }

    @Test
    void setName() {
        fail("Unimplemented");
    }

    @Test
    void setID() {
        fail("Unimplemented");
    }

    @Test
    void getPrereqs() {
        fail("Unimplemented");
    }

    @Test
    void getCoreqs() {
        fail("Unimplemented");
    }

    @Test
    void addPrereq() {
        fail("Unimplemented");
    }

    @Test
    void addCoreq() {
        fail("Unimplemented");
    }

    @Test
    void removePrereq() {
        fail("Unimplemented");
    }

    @Test
    void removeCoreq() {
        fail("Unimplemented");
    }
}