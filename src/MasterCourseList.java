import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterCourseList {

    // update to use a file.
    private static final String fileName = "";

    private static ArrayList<BaseCourse> courseList = new ArrayList<>();

    // Essentially remove default constructor
    private MasterCourseList() { }

    public static void init() {
        // TODO populate courseList from file
    }

    public static void addCourse(BaseCourse course) {
        courseList.add(course);
    }

    public static boolean removeCourse(BaseCourse course) {
        return courseList.remove(course);
    }

    public static List<BaseCourse> getCourseList() {
        return Collections.unmodifiableList(courseList);
    }
}
