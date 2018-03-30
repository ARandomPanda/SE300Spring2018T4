import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

//comment
public class Semester implements Comparable<Semester> {
    private Term term;
    private int year;
    private ArrayList<Course> courses = new ArrayList<>();

    public Semester() { }

    public Semester(Term term, int year) {
        this.term = term;
        this.year = year;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addCourse(Course course) {
        if (course == null) {
            throw new NullPointerException();
        }
        courses.add(course);
    }

    public void removeCourse(Course course){
        courses.remove(course);
    }

    public ObservableList<Course> getCourses(){
        return FXCollections.unmodifiableObservableList(FXCollections.observableList(courses));
    }

    public Term getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Semester other) {
        if (other == null) {
            return 1;
        }
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

    @Override
    public String toString() {
        return term.toString() + ' ' + year;
    }
}
