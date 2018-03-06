import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Collections;
>>>>>>> master
import java.util.List;


public class DegreeProgram {

    private int catalogYear;
    private float overallgpa;
    private float semestergpa;
<<<<<<< HEAD
    private string program;

    ArrayList requiredClass = new ArrayList();

    public setProgram(string program) {
=======
    private String program;

    private ArrayList<RequiredCourse> requiredClass = new ArrayList<RequiredCourse>();

    public void setProgram(String program) {
>>>>>>> master
        this.program = program;
    }

    public void setYear(int catalogYear) {
        this.catalogYear = catalogYear;
    }

<<<<<<< HEAD
    public ArrayList setRequiredClass(ArrayList course){
        requiredClass = add.course;
    }

    public ArrayList getRequiredClass() {
        return requiredClass;
=======
    public void setRequiredClass(BaseCourse course, Grade grade) {
        requiredClass.add(new RequiredCourse(course, grade));
    }

    public List<RequiredCourse> getRequiredClass() {
        return Collections.unmodifiableList(requiredClass);
>>>>>>> master
    }

    public float getOverallgpa() {
        return overallgpa;
    }

    public float getSemestergpa() {
        return semestergpa;
    }

<<<<<<< HEAD
    public getProgram{
        return program;
    }

    public getCatalogYear{
        return catalogYear; 
=======
    public String getProgram() {
        return program;
    }

    public int getCatalogYear() {
        return catalogYear;
>>>>>>> master
    }

}