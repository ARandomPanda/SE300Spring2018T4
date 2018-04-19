import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//comment
public class Semester implements Serializable, Comparable<Semester> {

    static final long serialVersionUID = 1L;

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

    public boolean addCourse(Course course) {
        if (course == null) {
            throw new NullPointerException();
        }
        return courses.add(course);
    }

    public boolean removeCourse(Course course){
        return courses.remove(course);
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
            if (this.term == null && other.term == null) {
                return 0;
            }
            if (this.term == null) {
                return -1;
            }
            if (other.term == null) {
                return 1;
            }
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
    
    public double calculateGPA() {
    	
    	Iterator<Course> iter = courses.iterator();
    	double GPA = 0.0;
		Course course;
		int completedCredits = 0, numberOfCompletedCourses = 0;
		
		while (iter.hasNext()) {
			course = (Course) iter.next();
			if (course.getGrade().getGradeValue() >= 0) {
				completedCredits += course.getNumCredits() * course.getGrade().getGradeValue();
				numberOfCompletedCourses++;
			}
		}
    	GPA = (double) completedCredits / numberOfCompletedCourses;
    	return GPA;
    }

    @Override
    public String toString() {
        return term.toString() + ' ' + year;
    }


}
