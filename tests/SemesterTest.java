import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {

    Semester semesterUnderTest;
    BaseCourse course1;
    BaseCourse course2;

    @BeforeEach
    void setUp() {
        semesterUnderTest = new Semester();
        course1 = new BaseCourse("Test 101", "Test Course", 3);
        course2 = new BaseCourse("Test 201", "Test Course", 3);
    }

    @Test
    void addCourseTest() {
        fail("Unimplemented");
        /*
        semesterUnderTest.addCourse(course1);
        assertTrue(semesterUnderTest.getCourses().contains(course), "Failed to add course");
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
        assertThrows(UnsupportedOperationException.class, () -> {
            semesterUnderTest.getCourses().add(course1);
        });
        */
    }
}