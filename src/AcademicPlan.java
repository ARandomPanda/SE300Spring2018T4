/**
 * @author Tyler Warner
 * Created: 03/23/2018
 * Modified: 03/26/2018
 * Fulfills the requirements to make an academic plan within the school planner application.
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.collections.ObservableList;

public class AcademicPlan implements Serializable{
	
	private static final long serialVersionUID = -8031135960947860998L;
	private DegreeProgram degree;
	private String degreeFileLocation;
	private ObservableList<Course> coursesNotInSemesters;
	private PersonalPlan personalPlan;
	private double GPA;
	private String saveLocation, catalogYear;
	
	/**
	 * Creates an empty academic plan
	 */
	public AcademicPlan() {
		initializeConstants();
		initializeObjects();
	}

	/**
	 * Creates an academic plan with the degree program attached
	 * @param degree A DegreeProgram object representing the chosen major of the student
	 */
	public AcademicPlan(DegreeProgram degree) {
		this.degree = degree;
		initializeConstants();
		initializeObjects();
	}

	private void initializeObjects() {
		personalPlan = new PersonalPlan();
	}

	private void initializeConstants() {
		GPA = 0.0;
		catalogYear = "catalog year";
		saveLocation = "assets/academicPlan.obj";
		degreeFileLocation = "assets/";
	}
	
	public void setDegree (DegreeProgram degree) {
		this.degree = degree;
	}
	
	public DegreeProgram getDegree () {
		return degree;
	}
	
	/**
	 * Save the plan's state
	 * @return true when successful
	 */
	public boolean savePlan() {
		FileOutputStream fOut = null;
		ObjectOutputStream oos = null;
		
		try {
			fOut = new FileOutputStream(saveLocation);
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
	
	/**
	 * Load the previous plan's state
	 * @return true when successful
	 */
	public boolean loadPlan() {
		FileInputStream fIn = null;
		ObjectInputStream ois = null;
		
		try {
			fIn = new FileInputStream(saveLocation);
			ois = new ObjectInputStream(fIn);
			ois.readObject();
			ois.close();
			fIn.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist for academic plan.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The academic plan object is missing from '" + saveLocation + "'.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("The academic plan object may be corrupted, causing a failure to load academic plan object.");
			e.printStackTrace();
		}
		return false;
	}

	private int calculateCredits() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Sets the years for the first academic calender in which the student made contractual relations with the school
	 * @param FallYear A string of the first year (YYYY format) of your first academic calender
	 * @param SpringYear A string of the second year (YYYY format) of your first academic calender
	 */
	public void setCatalogYear(String FallYear, String SpringYear) {
		// TODO restrict inputs to just numbers like 20XX
		this.catalogYear = FallYear + " - " + SpringYear;
	}
	
	public String getCatalogYear () {
		return catalogYear;
	}
	
	public double getCumulativeGPA () {
		return GPA;
	}
	
	private void calculateGPA () {
		// TODO
	}
	
	public ObservableList<Course> getCourseList () {
		return coursesNotInSemesters;
	}
	
	private void updateCourseList () {
		// TODO
	}

	public boolean setPlanSaveLocation (String location) {
		if (location == null) {
			return false;
		} else {
			this.saveLocation = location;
			return true;
		}
	}
	
	public String getPlanSaveLocation () {
		return saveLocation;
	}
	
	public PersonalPlan getPersonalPlan() {
		return personalPlan;
	}
}