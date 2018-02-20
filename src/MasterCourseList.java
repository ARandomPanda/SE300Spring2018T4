import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterCourseList {

    // update to use a file.
    private static final String fileName = "";

    private static ArrayList<Course> courseList = new ArrayList<>();

    // Essentially remove default constructor
    private MasterCourseList() { }

    public static void init() {
        // TODO populate courseList from file
    }

    public static void addCourse(Course course) {
        courseList.add(course);
    }

    public static List<Course> getCourseList() {
        return Collections.unmodifiableList(courseList);
    }
}
