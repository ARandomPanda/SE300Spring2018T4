import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;


public class PersonalPlan {

    private ArrayList<Semester> semesters = new ArrayList<>();

    PersonalPlan() { }

    public void addSemester(Semester semester) {
        if (semester == null) {
            throw new NullPointerException();
        }
        semesters.add(semester);
        Collections.sort(semesters);
    }

    public void removeSemester(Semester semester){
        semesters.remove(semester);
    }

    public ObservableList<Semester> getSemesters() {
        return FXCollections.unmodifiableObservableList(FXCollections.observableList(semesters));
    }

}