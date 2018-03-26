import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AcademicPlan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DegreeProgram> degrees;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private short credits;
	@SuppressWarnings("unused")
	private double GPA;
	
	AcademicPlan() {
		degrees = new ArrayList<DegreeProgram>();
		credits = 0;
		GPA = 0.0;
	}
	
	AcademicPlan(ArrayList<DegreeProgram> listOfDegrees) {
		this.degrees = listOfDegrees;
		credits = 0;
		GPA = 0.0;
	}

	AcademicPlan(ArrayList<DegreeProgram> listOfDegrees, String name) {
		this.degrees = listOfDegrees;
		this.name = name;
		credits = 0;
		GPA = 0.0;
	}

	/**
	 * 
	 * @param degree - degree program/major
	 * @return returns true when successful (appended to list)
	 */
	public boolean addDegree(DegreeProgram degree) {
		return degrees.add(degree);
	}

	/**
	 * 
	 * @param degree - degree program/major
	 * @return returns true when list changes (first matching element was found and removed)
	 */
	public boolean removeDegree(DegreeProgram degree) {
		return degrees.remove(degree);
	}
	
	public boolean savePlan() {
		FileOutputStream fOut = null;
		ObjectOutputStream oos = null;
		String current_directory = System.getProperty("user_dir");
		
		try { //TODO complete to save academic plan
			fOut = new FileOutputStream(current_directory);
			oos = new ObjectOutputStream(fOut);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return false;
	}
}
