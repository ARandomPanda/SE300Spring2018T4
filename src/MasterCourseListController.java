import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class MasterCourseListController {

    private static final MasterCourseList masterCourseList = MasterCourseList.get();

    public static class AddCourse implements EventHandler<ActionEvent> {

        private BaseCourse course;

        public AddCourse(String ID, String name, int numCredits, List<BaseCourse> prereqs, List<BaseCourse> coreqs) {
            course = new BaseCourse(ID, name, numCredits, prereqs, coreqs);
        }

        public void handle(ActionEvent e) {
            masterCourseList.addCourse(course);
        }
    }
}
