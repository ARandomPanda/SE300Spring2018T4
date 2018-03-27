import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PersonalPlan {

    private int catalogYear;
    private String program;
    private ArrayList<ArrayList> semesters;

    private ArrayList<RequiredCourse> requiredClass = new ArrayList<RequiredCourse>();


    PersonalPlan() {
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setCatalogYear(int catalogYear) {
        this.catalogYear = catalogYear;
    }


    public void setRequiredClass(BaseCourse course) {
        requiredClass.add(new RequiredCourse(course));
    }

    public List<RequiredCourse> getRequiredClass() {
        return Collections.unmodifiableList(requiredClass);
    }

    public String getProgram() {
        return program;
    }

    public void addSemester(ArrayList Semester) {
        semesters.add(Semester);
    }

    public void removeSemester(ArrayList Semester) {
        semesters.remove(Semester);
    }

    public ArrayList<ArrayList> getSemesters() {
        return semesters;
    }

    public int getCatalogYear() {
        return catalogYear;
    }
    
}