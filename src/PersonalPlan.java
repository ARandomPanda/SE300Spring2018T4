import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PersonalPlan {

    private int catalogYear;
    private float overallgpa;
    private float semestergpa;

    private String program;

    private ArrayList<RequiredCourse> requiredClass = new ArrayList<RequiredCourse>();

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int catalogYear) {
        this.catalogYear = catalogYear;
    }


    public void setRequiredClass(BaseCourse course, Grade grade) {
        requiredClass.add(new RequiredCourse(course, grade));
    }

    public List<RequiredCourse> getRequiredClass() {
        return Collections.unmodifiableList(requiredClass);

    }

    public float getOverallgpa() {
        return overallgpa;
    }

    public float getSemestergpa() {
        return semestergpa;
    }

    public String getProgram(){
        return program;
    }

    public int getCatalogYear(){
        return catalogYear;
    }



}