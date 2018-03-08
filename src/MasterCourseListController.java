import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

import static javafx.event.ActionEvent.ACTION;

/**
 * @author Christopher McFall
 *
 * Controller for the master course list. Any actions for the master course list from the gui must go through this class
 */
public class MasterCourseListController {

    private static final MasterCourseList masterCourseList = MasterCourseList.get();

    public static void openNewCourseWindow() {
        CreateMasterCourseWindow.init();
        CreateMasterCourseWindow.show();
    }

    public static void deleteCourse(TableView.TableViewSelectionModel<BaseCourse> selection) {
        BaseCourse course = selection.getSelectedItem();
        masterCourseList.removeCourse(course);
    }

    public static void addCourse(TextField IDField, TextField nameField, ChoiceBox<Integer> numCreditsField,
                                 ComboBox<BaseCourse> pre1, ComboBox<BaseCourse> pre2,
                                 ComboBox<BaseCourse> co1, ComboBox<BaseCourse> co2) {

        String currentText = IDField.getText();
        IDField.setText(currentText.toUpperCase());
        currentText = IDField.getText();

        boolean validID = currentText.matches("[A-Z]{2,5} [0-9]{3}");

        if (validID) {
            ArrayList<BaseCourse> prereqs = new ArrayList<>(2);
            ArrayList<BaseCourse> coreqs = new ArrayList<>(2);

            BaseCourse pre1Selection = pre1.getSelectionModel().getSelectedItem();
            BaseCourse pre2Selection = pre2.getSelectionModel().getSelectedItem();
            BaseCourse co1Selection = co1.getSelectionModel().getSelectedItem();
            BaseCourse co2Selection = co2.getSelectionModel().getSelectedItem();

            BaseCourse course = new BaseCourse(IDField.getText(), nameField.getText(), numCreditsField.getValue());
            if (pre1Selection != null) {
                course.addPrereq(pre1Selection);
            }
            if (pre2Selection != null) {
                course.addPrereq(pre2Selection);
            }
            if (co1Selection != null) {
                course.addCoreq(co1Selection);
            }
            if (co2Selection != null) {
                course.addCoreq((co2Selection));
            }

            masterCourseList.addCourse(course);
            IDField.clear();
            nameField.clear();

            pre1.getSelectionModel().clearSelection();
            pre2.getSelectionModel().clearSelection();
            co1.getSelectionModel().clearSelection();
            co2.getSelectionModel().clearSelection();
            numCreditsField.setValue(3);
        }
    }

    // TODO this needs to be handled with a static method, not a static class
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

        @Override
        public void handle(ActionEvent e) {
            if (verifyID() && verifyName()) {
                BaseCourse course = new BaseCourse(IDField.getText(), nameField.getText(), numCreditsField.getValue());
                masterCourseList.addCourse(course);
                IDField.clear();
                nameField.clear();
                numCreditsField.setValue(3);
                // TODO do something with prereqs and coreqs
            }
            // TODO do something when false
        }

        private boolean verifyID() {
            String currentText = IDField.getText();
            IDField.setText(currentText.toUpperCase());
            currentText = IDField.getText();

            return currentText.matches("[A-Z]{2,5} [0-9]{3}");
        }

        private boolean verifyName() {
            return true;
        }
    }
}
