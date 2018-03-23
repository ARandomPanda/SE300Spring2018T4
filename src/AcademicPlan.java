import java.util.ArrayList;

public class AcademicPlan {
	
	@SuppressWarnings("unused")
	private ArrayList<DegreeProgram> degrees;
	@SuppressWarnings("unused")
	private short credits;
	@SuppressWarnings("unused")
	private float GPA;
	
	AcademicPlan() {
		degrees = null;
	}
	
	AcademicPlan(ArrayList<DegreeProgram> listOfDegrees) {
		this.degrees = listOfDegrees;
	}

}
