import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class PersonalPlan {

    private int catalogYear;
    private String program;
    private ArrayList<ArrayList> semesters;

    private ArrayList<BaseCourse> requiredClass = new ArrayList<>();


    PersonalPlan() {
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setCatalogYear(int catalogYear) {
        this.catalogYear = catalogYear;
    }


    public void setRequiredClass(BaseCourse course) {
        requiredClass.add(course);
    }

    public ObservableList<BaseCourse> getRequiredClass() {
        return FXCollections.unmodifiableObservableList(FXCollections.observableList(requiredClass));
    }

    public String getProgram() {
        return program;
    }

    public void addSemester(Semester Semester){
        semesters.add(semesters);
    }

    public void removeSemester(Semester Semester){
        semesters.remove(semesters);
    }

    public ArrayList<ArrayList> getSemesters() {
        return semesters;
    }

    public int getCatalogYear() {
        return catalogYear;
    }

}