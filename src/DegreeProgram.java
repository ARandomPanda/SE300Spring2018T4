import java.util.ArrayList;


public class DegreeProgram extends Semester {
    private int catalogYear;
    private String program;

    private ArrayList<RequiredCourse> requiredClass;
    private ArrayList<String> semesters;

    public static void main(String[] args) {
    }

    private DegreeProgram() {
        requiredClass = new ArrayList<RequiredCourse>();
    }


    public void addCourse(BaseCourse course) {
        requiredClass.add(new RequiredCourse(course));
    }

    public void removeCourse(BaseCourse course){
        requiredClass.remove(course);
    }


    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setYear(int catalogYear) {
        this.catalogYear = catalogYear;
    }


    public void setCatalogYear(int Year){
        catalogYear = Year;
    }

    public int getCatalogYear() {
        return catalogYear;
    }


}