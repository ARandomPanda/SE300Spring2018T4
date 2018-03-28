import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

//comment
public class Semester {
    private String term;
    private int year;
    private ArrayList<BaseCourse> semesterClass = new ArrayList<>();

    Semester() {
    }

    public void setTerm(String terminput) {
        term = terminput;
    }

    public void setYear(int yearinput) {
        year = yearinput;
    }

    public void addCourse(BaseCourse course) {
        semesterClass.add(course);
    }

    public void removeCourse(BaseCourse course){
        semesterClass.remove(course);
    }

    public ObservableList<BaseCourse> getCourses(){
        return FXCollections.unmodifiableObservableList(FXCollections.observableList(semesterClass));
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

}
