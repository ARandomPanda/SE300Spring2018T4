import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class Semester{
    private string term;
    private int year;
    private ArrayList semester = new ArrayList();

    public setTerm(string term){
        this.term = term;
    }

    public setYear( int year){
        this.year = year;
    }

    public ArrayList setCourse(ArrayList course){
        semester = add.course
    }

    public getTerm{
        return this.term;
    }

    public getYear{
        return this.year;
    }

    public ArrayList getCourse{
        return semester;
    }
=======
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
>>>>>>> master
