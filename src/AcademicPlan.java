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
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.ObservableList;

public class AcademicPlan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<DegreeProgram> listOfDegrees;
	private ArrayList<String> degreeFileLocations;
	private ArrayList<Integer> cumulativeCreditsPerDegree;
	// TODO figure out how to add all courses in one list
	// TODO maintain course list not in any semester
	private ObservableList<Course> coursesNotInSemesters, allCoursesInPlan;
	private PersonalPlan personalPlan = new PersonalPlan();
	private double GPA;
	private String fileLocation, catalogYear;
	
	/**
	 * Creates an empty academic plan
	 */
	public AcademicPlan() {
		listOfDegrees = new ArrayList<DegreeProgram>();
		initializeConstants();
	}

	/**
	 * Creates an academic plan with the degree program attached
	 * @param degree A DegreeProgram object representing the chosen major of the student
	 */
	public AcademicPlan(DegreeProgram degree) {
		this.listOfDegrees.add(degree);
		initializeConstants();
		initializeLists();
		removeRedundantCourses();
	}
	
	private void removeRedundantCourses() {
		// TODO Auto-generated method stub
		
	}

	private void initializeLists() {
		// TODO Auto-generated method stub
		// iterate through each degree and pull classes
		
	}

	private void initializeConstants() {
		this.cumulativeCreditsPerDegree = new ArrayList<Integer>();
		GPA = 0.0;
		// TODO allow user to specify location
		fileLocation = "assets/academicPlan.obj";
	}

	/**
	 * 
	 * @param degree - degree program/major
	 * @return returns true when successful (appended to list)
	 */
	public boolean addDegree(DegreeProgram degree) {
		return listOfDegrees.add(degree);
	}

	/**
	 * 
	 * @param degree - degree program/major
	 * @return returns true when list changes (first matching element was found and removed)
	 */
	public boolean removeDegree(DegreeProgram degree) {
		return listOfDegrees.remove(degree);
	}
	
	/**
	 * Save the plan's state
	 * @return true when successful
	 */
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
	
	/**
	 * Load the previous plan's state
	 * @return true when successful
	 */
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

	public int calculateCredits() {
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
	
	public double getCumulativeGPA () {
		int count = 0;
		double sum = 0;
		Course course;
		Iterator<Course> itr = allcoursesInPlan.iterator();
		while (itr.hasNext()) {
			if ((course = itr.next()) != null) {
				count++;
				sum += course.getGrade().getGradeValue();
			}
		}
		return (sum / count);
	}

	public boolean addDegreeFileLocation (String location) {
		if (location == null) {
			return false;
		} else {
			return this.degreeFileLocations.add(location);
		}
	}
	
	public boolean removeDegreeFileLocation (String location) {
		if (location == null) {
			return false;
		} else {
			return degreeFileLocations.remove(location);
		}
	}
	
	public boolean setPlanSaveLocation (String location) {
		if (location == null) {
			return false;
		} else {
			this.fileLocation = location;
			return true;
		}
	}
	
	public String getPlanFileLocation () {
		return fileLocation;
	}
	
	public PersonalPlan getPersonalPlan() {
		return personalPlan;
	}
}