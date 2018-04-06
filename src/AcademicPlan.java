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
import java.util.Iterator;

import javafx.collections.ObservableList;

public class AcademicPlan implements Serializable{

	private static final long serialVersionUID = -8031135960947860998L;
	private DegreeProgram degree;
	private String degreeFileLocation;
	private ObservableList<Course> coursesNotInSemesters;
	private ObservableList<Semester> semesters;
	private PersonalPlan personalPlan;
	private int credits, numberOfCourses;
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
		semesters = personalPlan.getSemesters();
	}

	private void initializeConstants() {
		GPA = 0.0;
		catalogYear = "catalog year";
		credits = 0;
		numberOfCourses = 0;
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

	private void calculateCreditsAndGPA () {
		credits = 0;
		int[] tmp = getCreditsFromSemesters(); // tmp = {gradeCreditsInSemesters, numberOfGradedCoursesInSemesters}
		int[] tmp2 = getCreditsFromCoursePool();
		GPA = (tmp[0] + tmp2[0]) / (tmp[1] + tmp2[1]);
	}
	/**
	 * Sets the years for the first academic calendar in which the student made contractual relations with the school
	 * @param FallYear A string of the first year (YYYY format) of your first academic calendar
	 * @param SpringYear A string of the second year (YYYY format) of your first academic calendar
	 */
	public void setCatalogYear(String FallYear, String SpringYear) {
		if (compareYears(FallYear, SpringYear)) {
			this.catalogYear = FallYear + " - " + SpringYear;
		}
	}

	public String getCatalogYear () {
		return catalogYear;
	}

	public double getCumulativeGPA () {
		return GPA;
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

	private boolean compareYears (String FallYear, String SpringYear) {
		int tmp;
		return (tmp = Integer.valueOf(FallYear).intValue()) > 2000 && Integer.valueOf(FallYear).intValue() < 3000 && Integer.valueOf(SpringYear) - 1 == tmp;
	}

	private int[] getCreditsFromCoursePool() {
		Iterator<Course> iter = coursesNotInSemesters.iterator();
		Course course;
		int completedCredits = 0, numberOfCompletedCourses = 0;
		while (iter.hasNext()) {
			course = (Course) iter.next();
			if (course.getGrade().getGradeValue() >= 0) {
				completedCredits += course.getNumCredits() * course.getGrade().getGradeValue();
				numberOfCompletedCourses++;
			}
		}
		int[] tmp = {completedCredits, numberOfCompletedCourses};
		return tmp;
	}

	private int[] getCreditsFromSemesters() {
		Iterator<Semester> iter = semesters.iterator();
		Semester semester;
		int completedCredits = 0, numberOfCompletedCourses = 0;
		while (iter.hasNext()) {
			semester = (Semester) iter.next();
			ObservableList<Course> courses = semester.getCourses();
			
			Iterator<Course> iter2 = courses.iterator();
			Course course;
			while (iter2.hasNext()) {
				course = (Course) iter2.next();
				credits += course.getNumCredits();
				if (course.getGrade().getGradeValue() >= 0) {
					completedCredits += course.getNumCredits() * course.getGrade().getGradeValue();
					numberOfCompletedCourses++;
				}
			}
		}
		int[] tmp = {completedCredits, numberOfCompletedCourses};
		return tmp;
	}

}