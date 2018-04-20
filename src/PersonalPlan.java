import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class PersonalPlan implements Serializable {

    static final long serialVersionUID = 1L;

    private ObservableList<Semester> semestersO = FXCollections.observableArrayList();

    PersonalPlan() { }

    public void addSemester(Semester semester) {
        if (semester == null) {
            throw new NullPointerException();
        }
        semestersO.add(semester);
        Collections.sort(semestersO);
    }

    public void removeSemester(Semester semester){
        semestersO.remove(semester);
    }

    public ObservableList<Semester> getSemesters() {
        return semestersO;
    }

}