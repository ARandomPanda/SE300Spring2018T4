import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AcademicPlan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DegreeProgram> degrees;
	private short credits;
	private double GPA;
	private String fileLocation, catalogYear;
	private ArrayList<String> degreeTitles;
	
	AcademicPlan() {
		degrees = new ArrayList<DegreeProgram>();
		initializeConstants();
	}

	AcademicPlan(DegreeProgram degree) {
		this.degrees.add(degree);
		initializeConstants();
	}
/* TODO replace this constructor by extracting the catalog year, title, etc. from the degree program object
	AcademicPlan(ArrayList<DegreeProgram> listOfDegrees, String degreeTitle) {
		this.degrees = listOfDegrees;
		this.addDegreeTitle(degreeTitle);
		initializeConstants();
	}
*/
	private void initializeConstants() {
		credits = 0;
		GPA = 0.0;
		fileLocation = "assets/academicPlan.obj";
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
		
		try {
			fOut = new FileOutputStream(fileLocation);
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(this);
			oos.close();
			fOut.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist for academic plan.");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The academic plan object can't be saved.");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean loadPlan() {
		FileInputStream fIn = null;
		ObjectInputStream ois = null;
		
		try {
			fIn = new FileInputStream(fileLocation);
			ois = new ObjectInputStream(fIn);
			ois.readObject();
			ois.close();
			fIn.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist for academic plan.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The academic plan object is missing from '" + fileLocation + "'.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("The academic plan object may be corrupted, causing a failure to load academic plan object.");
			e.printStackTrace();
		}
		return false;
	}

	public double calculateGPA() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int calculateCredits() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setCatalogYear(String year) {
		this.catalogYear = year;
	}
	
	private boolean addDegreeTitle(String title) {
		return this.degreeTitles.add(title);
	}
	
	private boolean removeDegreeTitle(String title) {
		return this.degreeTitles.remove(title);
	}
}
