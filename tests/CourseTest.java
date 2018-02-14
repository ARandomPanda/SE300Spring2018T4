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
    void getNumCredits() {
        assertEquals(0, testA.getNumCredits());
        assertEquals(3, testB.getNumCredits());
        assertEquals(6, testC.getNumCredits());
    }

    @Test
    void setNumCredits() {
        fail("Unimplemented");
    }

    @Test
    void getGrade() {
        fail("Unimplemented");
    }

    @Test
    void setGrade() {
        fail("Unimplemented");
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