import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterCourseList {

    // update to use a file.
    private static final String fileName = "";

    private static ArrayList<Course> courseList = null;

    // Essentially remove default constructor
    private MasterCourseList() { }

    public static void init() {
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
    }

    public static void addCourse(Course course) {
        courseList.add(course);
    }

    public static List<Course> getCourseList() {
        return Collections.unmodifiableList(courseList);
    }
}
