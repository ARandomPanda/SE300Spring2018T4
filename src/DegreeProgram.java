
import java.util.ArrayList;


public class DegreeProgram extends Semester {
    /**
	 * 
	 */
	private static final long serialVersionUID = 377635845681135207L;
	private int catalogYear;
    private String program;

    private ArrayList<RequiredCourse> requiredClass;
    private ArrayList<String> semesters;

    public static void main(String[] args) {
    }

    DegreeProgram() {
        super();
        requiredClass = new ArrayList<RequiredCourse>();
    }


    public void addCourse(BaseCourse course) {
        requiredClass.add(new RequiredCourse(course));
    }

    public void removeCourse(BaseCourse course){
        requiredClass.remove(course);
    }

    public void addSemester(String Semester){
        semesters.add(Semester);
    }

    public void removeSemester(String Semester){
        semesters.remove(Semester);
    }

    public ArrayList<String> getSemesters(){
        return semesters;
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
