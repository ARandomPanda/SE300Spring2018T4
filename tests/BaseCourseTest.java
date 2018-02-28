import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBaseCourseTest {

    private BaseCourse testA;
    private BaseCourse testB;
    private BaseCourse testC;

    @BeforeEach
    void makeTestBaseCourse() {
        testA = new BaseCourse("AA 101", "TestA", 0);
        testB = new BaseCourse("BB 101", "TestB", 3);
        testC = new BaseCourse("CC 101", "TestC", 6);
    }

    @Test
    void constructor() {
        BaseCourse a = new BaseCourse("AA 101", "TestA", 0);
        BaseCourse b = new BaseCourse("BB 101", "TestB", 6);
        BaseCourse c = new BaseCourse("CC 101", "TestC", 3);
        assertThrows(NullPointerException.class,
                () -> new BaseCourse(null, "Test", 0));
        assertThrows(NullPointerException.class,
                () -> new BaseCourse("Test", null, 0));
        assertThrows(NullPointerException.class,
                () -> new BaseCourse(null, null, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new BaseCourse("a", "b", -1));
        assertThrows(IllegalArgumentException.class,
                () -> new BaseCourse("a", "b", 7));
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
    void addPrereqs() {
        assertFalse(testA.getPrereqs().contains(testB));
        testA.addPrereq(testB);
        assertTrue(testA.getPrereqs().contains(testB));
        assertFalse(testA.getPrereqs().contains(testC));
        testA.addPrereq(testC);
        assertTrue(testA.getPrereqs().contains(testC));
    }

    @Test
    void removePrereqs() {
        assertFalse(testA.getPrereqs().contains(testB));
        assertFalse(testA.getPrereqs().contains(testC));
        testA.addPrereq(testB);
        testA.addPrereq(testC);
        assertTrue(testA.getPrereqs().contains(testB));
        assertTrue(testA.getPrereqs().contains(testC));
        testA.removePrereq(testC);
        assertFalse(testA.getPrereqs().contains(testC));
        assertFalse(testA.removePrereq(testC));
        assertTrue(testA.getPrereqs().contains(testB));
        testA.removePrereq(testB);
        assertFalse(testA.getPrereqs().contains(testB));
    }

    @Test
    void addCoreqs() {
        assertFalse(testA.getCoreqs().contains(testB));
        testA.addCoreq(testB);
        assertTrue(testA.getCoreqs().contains(testB));
        assertFalse(testA.getCoreqs().contains(testC));
        testA.addCoreq(testC);
        assertTrue(testA.getCoreqs().contains(testC));
    }

    @Test
    void removeCoreqs() {
        assertFalse(testA.getCoreqs().contains(testB));
        assertFalse(testA.getCoreqs().contains(testC));
        testA.addCoreq(testB);
        testA.addCoreq(testC);
        assertTrue(testA.getCoreqs().contains(testB));
        assertTrue(testA.getCoreqs().contains(testC));
        testA.removeCoreq(testC);
        assertFalse(testA.getCoreqs().contains(testC));
        assertFalse(testA.removeCoreq(testC));
        assertTrue(testA.getCoreqs().contains(testB));
        testA.removeCoreq(testB);
        assertFalse(testA.getCoreqs().contains(testB));
    }
}
