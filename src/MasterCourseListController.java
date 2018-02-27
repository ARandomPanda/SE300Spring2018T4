import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class MasterCourseListController {

    private static final MasterCourseList masterCourseList = MasterCourseList.get();

    public static class AddCourse implements EventHandler<ActionEvent> {

        private TextField IDField;
        private TextField nameField;
        private ChoiceBox<Integer> numCreditsField;
        private TextField prereqsField;
        private TextField coreqsField;

        public AddCourse(TextField IDField, TextField nameField, ChoiceBox<Integer> numCreditsField,
                         TextField prereqsField, TextField coreqsField) {
            this.IDField = IDField;
            this.nameField = nameField;
            this.numCreditsField = numCreditsField;
            this.prereqsField = prereqsField;
            this.coreqsField = coreqsField;
        }

        public void handle(ActionEvent e) {
            BaseCourse course = new BaseCourse(IDField.getText(), nameField.getText(), numCreditsField.getValue());
            masterCourseList.get().addCourse(course);
            NewCourseWindow.hide();
        }
    }
}
