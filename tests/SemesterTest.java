import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {

    Semester semesterUnderTest;

    @BeforeEach
    void setUp() {
        semesterUnderTest = new Semester();
    }

    @Test
    void addCourseTest() {
        fail("Unimplemented");
        /*
        BaseCourse course1 = new BaseCourse("Test 101", "Test Course", 3);
        semesterUnderTest.addCourse(course1);
        assertTrue(semesterUnderTest.getCourses().contains(course), "Failed to add course");
        BaseCourse course2 = new BaseCourse("Test 102", "Test Course", 3);
        semesterUnderTest.addCourse(course2);
        assertTrue(semesterUnderTest.getCourses().contains(course2), "Failed to add another course");
        */
    }

    @Test
    void addCourseFailTest() {
        fail("Unimplemented");
        /*
        assertThrows(NullPointerException.class, () -> semesterUnderTest.addCourse(null),
                "Failed to throw NullPointerException");
                */
    }

    @Test
    void removeCourseTest() {
        fail("Unimplemented");
        /*
        BaseCourse course1 = new BaseCourse("Test 101", "Test Course", 3);
        BaseCourse course2 = new BaseCourse("Test 201", "Test Course", 3);
        semesterUnderTest.addCourse(course1);
        semesterUnderTest.addCourse(course2);
        semesterUnderTest.removeCourse(course1);
        assertFalse(semesterUnderTest.getCourses().contains(course1), "Failed to remove course");
        assertTrue(semesterUnderTest.getcourses().contains(course2), "Removed a course that wasn't meant to be");
        */
    }

    @Test
    void getCoursesTest() {
        fail("Unimplemented");
        /*
        assertTrue(semesterUnderTest.getCourses().getClass() == ObservableList.class);
        BaseCourse course1 = new BaseCourse("Test 101", "Test Course", 3);
        assertThrows(UnsupportedOperationException.class, () -> {
            semesterUnderTest.getCourses().add(course1);
        });
        */
    }

    @AfterEach
    void tearDown() {

    }
}