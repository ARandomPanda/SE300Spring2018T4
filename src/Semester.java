import java.util.ArrayList;

//comment
public class Semester extends BaseCourse {
    private String term;
    private int year;
    private ArrayList<RequiredCourse> semesterClass;

    Semester() {
        semesterClass = new ArrayList<>();
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addCourse(BaseCourse course) {
        semesterClass.add(new RequiredCourse(course));
    }

    public void removeCourse(BaseCourse course){
        semesterClass.remove(course);
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

}
