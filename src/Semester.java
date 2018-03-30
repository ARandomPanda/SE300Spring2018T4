import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

//comment
public class Semester implements Comparable<Semester> {
    private Term term;
    private int year;
    private ArrayList<Course> semesterClass = new ArrayList<>();

    Semester() {
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addCourse(BaseCourse course) {
        semesterClass.add(new Course(course));
    }

    public void removeCourse(Course course){
        semesterClass.remove(course);
    }

    public ObservableList<Course> getCourses(){
        return FXCollections.unmodifiableObservableList(FXCollections.observableList(semesterClass));
    }

    public Term getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Semester other) {
        if (this.year == other.year) {
            return term.compareTo(other.term);
        } else {
            if (this.year > other.year) {
                return 1;
            } else if (this.year < other.year) {
                return -1;
            }
        }
        // should be unreachable
        return 0;
    }
}
