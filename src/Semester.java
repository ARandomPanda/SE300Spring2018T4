import java.util.ArrayList;

//comment
public class Semester {
    private String term;
    private int year;
    private ArrayList<RequiredCourse> semesterClass = new ArrayList<>();;

    Semester() {
    }

    public void setTerm(String terminput) {
        term = terminput;
    }

    public void setYear(int yearinput) {
        year = yearinput;
    }

    public void addCourse(BaseCourse course) {
        semesterClass.add(new RequiredCourse(course));
    }

    public void removeCourse(BaseCourse course){
        semesterClass.remove(course);
    }

    public ArrayList<RequiredCourse> getCourses (){
        return  semesterClass;
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

}
