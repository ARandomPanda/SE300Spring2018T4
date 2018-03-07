import java.util.ArrayList;
import java.util.List;


// push comment
public class Semester {
    private String term;
    private int year;
    private ArrayList<RequiredCourse> semesterClass = new ArrayList<RequiredCourse>();

    public void setTerm(String term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCourse(BaseCourse course, Grade grade) {
        semesterClass.add(new RequiredCourse(course, grade));
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    public List<RequiredCourse> getCourse() {
        return semesterClass;
    }
}
