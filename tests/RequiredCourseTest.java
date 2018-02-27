import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequiredCourseTest {

    @Test
    void constructorTest() {
        assertThrows(NullPointerException.class, () -> {
            new RequiredCourse(null, Grade.A);
        });
        BaseCourse bc = new BaseCourse("Test 101", "Test", 3);
        assertThrows(IllegalArgumentException.class, () -> {
            new RequiredCourse(bc, Grade.F);
        });

        RequiredCourse rc = new RequiredCourse(bc, Grade.B);
        assertEquals(bc, rc.getBaseCourse());
        assertEquals(Grade.B, rc.getRequiredGrade());
    }

}