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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AcademicPlan implements Serializable {

	private static final long serialVersionUID = -8031135960947860998L;
	private DegreeProgram degree;
	private String degreeFileLocation;
	private ArrayList<Course> coursesNotInSemesters;
	private ArrayList<Semester> semesters;
	private PersonalPlan personalPlan;
	private int credits, catalogYear;
	private double GPA;
	private static String saveLocation;

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
		coursesNotInSemesters = new ArrayList<Course>();
		semesters = new ArrayList<Semester>();
		degree = null;
	}

	private void initializeConstants() {
		GPA = 0.0;
		catalogYear = 2015;
		credits = 0;
		saveLocation = "assets/academicPlan.obj";
		degreeFileLocation = "assets/";
	}

	public void setPrimaryDegree (DegreeProgram degree) {
		this.degree = degree;
	}

	public DegreeProgram getDegree () {
		return degree;
	}
	
	public void removeDegree () {
		// TODO How to remove courses from the degree
		degree = null;
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
	public static AcademicPlan loadPlan() {//String filename) {
		FileInputStream fIn = null;
		ObjectInputStream ois = null;
		AcademicPlan plan;

		try {
			fIn = new FileInputStream(saveLocation);
			ois = new ObjectInputStream(fIn);
			plan = (AcademicPlan) ois.readObject();
			ois.close();
			fIn.close();
			return plan;
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
		return null;
	}

	public void setCatalogYear(int year) {
		if (year > 2000 && year < 3000) { // "reasonable" limitations
			this.catalogYear = year;
		}
	}

	public int getCatalogYear () {
		return catalogYear;
	}

	public double getCumulativeGPA () {
		return GPA;
	}

	public ObservableList<Course> getUnplannedCourses () {
		return FXCollections.observableArrayList(coursesNotInSemesters);
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
	
	public void setDegreeFileLocation(String location) {
		this.degreeFileLocation = location;
	}
	
	public String getDegreeFileLocation() {
		return degreeFileLocation;
	}
	
	public void setPersonalPlan(PersonalPlan plan) {
		this.personalPlan = plan;
	}
	
	public ObservableList<Semester> getSemesterList() {
		return personalPlan.getSemesters();
	}
	
	public boolean loadDegree() {
		// TODO how to load courses into list?
		return false;
	}
	
	public boolean moveCourseToSemester(Semester semester, Course course) {
		if (coursesNotInSemesters.remove(course)) {
			return semester.addCourse(course);
		}
		return false;
	}
	
	public boolean moveCourseToCoursePool(Semester semester, Course course) {
		if (semester.removeCourse(course)) {
			return coursesNotInSemesters.add(course);
		}
		return false;
	}

	public void moveCourseSemesterToSemester(Semester from, Semester to, Course course) {
		if (from.removeCourse(course)) {
			to.addCourse(course);
		}
	}

	public double calculateCreditsAndGPA () {
		// TODO get unique courses, THEN calculate credits and GPA
		//ArrayList<Course> uniqueCourses = getNewestCourses();
		
		// tmp = {gradeCreditsInSemesters, numberOfGradedCoursesInSemesters, totalNongradedCredits}
		int[] tmp = getCreditsFromSemesters();
		int[] tmp2 = getCreditsFromCoursePool();
		if (tmp[1] == 0 || tmp2[1] == 0) {
			return 0.0;
		} else {
			GPA = (double) (tmp[0] + tmp2[0]) / (tmp[1] + tmp2[1]);
		}
		credits += tmp[2] + tmp2[2];
		return GPA;
	}
	
	/**
	 * Grabs all the newest courses from the academic plan. This will ignore previously graded 
	 * courses if a newer one already has a grade.
	 * @return list of unique courses
	 */
	/*private ArrayList<Course> getNewestCourses() {
		// TODO Auto-generated method stub
		return null;
	}*/

	private int[] getCreditsFromCoursePool() {
		Iterator<Course> iter = coursesNotInSemesters.iterator();
		Course course;
		int completedCredits = 0, numberOfCompletedCourses = 0, totalNongradedCredits = 0;
		while (iter.hasNext()) {
			course = (Course) iter.next();
			if (course.getGrade().getGradeValue() >= 0) {
				completedCredits += course.getNumCredits() * course.getGrade().getGradeValue();
				numberOfCompletedCourses++;
			}
			totalNongradedCredits += course.getNumCredits();
		}
		int[] tmp = {completedCredits, numberOfCompletedCourses, totalNongradedCredits};
		return tmp;
	}

	private int[] getCreditsFromSemesters() {
		Iterator<Semester> iter = semesters.iterator();
		Semester semester;
		int completedCredits = 0, numberOfCompletedCourses = 0, totalNongradedCredits = 0;
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
				totalNongradedCredits += course.getNumCredits();
			}
		}
		int[] tmp = {completedCredits, numberOfCompletedCourses, totalNongradedCredits};
		return tmp;
	}
	
	public int getCredits () {
		return credits;
	}
	
	public boolean addCourse (Course course) {
		return coursesNotInSemesters.add(course);
	}
	
	public boolean removeCourse (Course course) {
		return coursesNotInSemesters.remove(course);
	}

}