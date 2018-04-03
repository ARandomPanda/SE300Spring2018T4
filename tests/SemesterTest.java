import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {

    private Semester semesterUnderTest;
    private Course course1;
    private Course course2;

    @BeforeEach
    void setUp() {
        semesterUnderTest = new Semester(Term.SPRING, 2018);
        BaseCourse baseCourse1 = new BaseCourse(DepartmentID.AF, 101, "Test Course", 3);
        BaseCourse baseCourse2 = new BaseCourse(DepartmentID.AF, 101, "Test Course", 3);
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

    @Test
    void comparableTest() {
        Semester other = new Semester(Term.SPRING, 2018);
        assertTrue(0 == semesterUnderTest.compareTo(other), "Compare equal is wrong");
        other.setTerm(Term.FALL);
        assertTrue(0 > semesterUnderTest.compareTo(other), "Compare less than is wrong");
        other.setYear(2019);
        assertTrue(0 > semesterUnderTest.compareTo(other), "Compare less than is wrong");
        other.setYear(2017);
        assertTrue(0 < semesterUnderTest.compareTo(other), "Compare greater than is wrong");
        other.setTerm(Term.SPRING);
        assertTrue(0 < semesterUnderTest.compareTo(other), "Compare greater than is wrong");
    }
}