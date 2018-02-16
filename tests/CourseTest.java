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
        assertTrue(Grade.A == testA.getGrade());
        assertTrue(testA.isAttempted());
    }

    @Test
    void setName() {
        String var = "varTest";
        testA.setName("test");
        assertEquals("test", testA.getName());
        testA.setName(var);
        assertEquals(var, testA.getName());
        assertThrows(NullPointerException.class,
                () -> testA.setName(null));
    }

    @Test
    void setID() {
        String var = "varTest";
        testA.setID("test");
        assertEquals("test", testA.getID());
        testA.setID(var);
        assertEquals(var, testA.getID());
        assertThrows(NullPointerException.class,
                () -> testA.setID(null));
    }

    @Test
    void getAddRemovePrereqs() {
        Course noCourses[] = new Course[0];
        Course oneCourse[] = {testB};
        Course twoCourse[] = {testB, testC};
        Course remCourse[] = {testC};
        assertArrayEquals(noCourses, testA.getPrereqs());
        testA.addPrereq(testB);
        assertArrayEquals(oneCourse, testA.getPrereqs());
        testA.addPrereq(testC);
        assertArrayEquals(twoCourse, testA.getPrereqs());
        testA.removePrereq(testB);
        assertArrayEquals(remCourse, testA.getPrereqs());
        assertThrows(NullPointerException.class,
                () -> testA.addPrereq(null));
        assertThrows(NullPointerException.class,
                () -> testA.removePrereq(null));
    }

    @Test
    void getAddRemoveCoreqs() {
        Course noCourses[] = new Course[0];
        Course oneCourse[] = {testB};
        Course twoCourse[] = {testB, testC};
        Course remCourse[] = {testC};
        assertArrayEquals(noCourses, testA.getCoreqs());
        testA.addCoreq(testB);
        assertArrayEquals(oneCourse, testA.getCoreqs());
        testA.addCoreq(testC);
        assertArrayEquals(twoCourse, testA.getCoreqs());
        testA.removeCoreq(testB);
        assertArrayEquals(remCourse, testA.getCoreqs());
        assertThrows(NullPointerException.class,
                () -> testA.addCoreq(null));
        assertThrows(NullPointerException.class,
                () -> testA.removeCoreq(null));
    }
}