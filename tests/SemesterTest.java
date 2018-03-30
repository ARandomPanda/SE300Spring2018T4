import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {

    Semester semesterUnderTest;
    Course course1;
    Course course2;
    BaseCourse baseCourse1;
    BaseCourse baseCourse2;

    @BeforeEach
    void setUp() {
        semesterUnderTest = new Semester();
        baseCourse1 = new BaseCourse("Test 101", "Test Course", 3);
        baseCourse2 = new BaseCourse("Test 201", "Test Course", 3);
        course1 = new Course(baseCourse1);
        course2 = new Course(baseCourse2);
    }

    @Test
    void addCourseTest() {
        semesterUnderTest.addCourse(course1);
        assertTrue(semesterUnderTest.getCourses().contains(course1), "Failed to add course");
        semesterUnderTest.addCourse(course2);
        assertTrue(semesterUnderTest.getCourses().contains(course2), "Failed to add another course");
    }

    @Test
    void addCourseFailTest() {
        assertThrows(NullPointerException.class, () -> semesterUnderTest.addCourse(null),
                "Failed to throw NullPointerException");
    }

    @Test
    void removeCourseTest() {
        semesterUnderTest.addCourse(course1);
        semesterUnderTest.addCourse(course2);
        semesterUnderTest.removeCourse(course1);
        assertFalse(semesterUnderTest.getCourses().contains(course1), "Failed to remove course");
        assertTrue(semesterUnderTest.getCourses().contains(course2), "Removed a course that wasn't meant to be");
    }

    @Test
    void getCoursesTest() {
        assertThrows(UnsupportedOperationException.class, () -> {
            semesterUnderTest.getCourses().add(course1);
        });
    }
}