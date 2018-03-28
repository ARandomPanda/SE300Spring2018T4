import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class PersonalPlan {

    private int catalogYear;
    private String program;
    private ArrayList<Semester> semesters = new ArrayList<Semester>();

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

    public void addSemester(Semester semester){
        semesters.add(semester);
    }

    public void removeSemester(Semester semester){
        semesters.remove(semester);
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public int getCatalogYear() {
        return catalogYear;
    }

}