import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * @authors Tyler Warner
 * Last modified: 03/01/2018
 *
 * Menu class holds the methods called by menu commands within the interface. These include, but are 
 * not limited to saving the academic plan, editing the plan, and modifying courses within the plan.
 */
public class ApplicationMenu {

	MenuBar menuBar = new MenuBar();

	// Menu tabs
	Menu file = new Menu("File");
	Menu course = new Menu("Course");
	Menu edit = new Menu("Edit");
	Menu status = new Menu("Status");
	
	// File
	MenuItem savePlan = new MenuItem("Save");
	MenuItem saveasPlan = new MenuItem("Save as");
	MenuItem loadPlan = new MenuItem("Load");
	MenuItem exportPlan = new MenuItem("Export");
	MenuItem printPlan = new MenuItem("Print");
	MenuItem refreshPlan = new MenuItem("Refresh Plan");
	// Course
	MenuItem addCourse = new MenuItem("Add Course");
	MenuItem addMajor = new MenuItem("Add Major");
	MenuItem addMinor = new MenuItem("Add Minor");
	MenuItem removeCourse = new MenuItem("Remove Course");
	MenuItem removeMajor = new MenuItem("Remove Major");
	MenuItem removeMinor = new MenuItem("Remove Minor");
	// Edit
	MenuItem resetCoursesToPool = new MenuItem("Send Courses to Pool");
	MenuItem resetCoursesToSemester = new MenuItem("Reset to Default");
	// Status
	MenuItem markDoneCourse = new MenuItem("Mark Course Completed");
	MenuItem markDoneSemester = new MenuItem("Mark Entire Semester Completed");
	
	ApplicationMenu() {
		// File 	
		file.getItems().add(savePlan);
		file.getItems().add(saveasPlan);
		file.getItems().add(loadPlan);
		file.getItems().add(exportPlan);
		file.getItems().add(printPlan);
		file.getItems().add(refreshPlan);
		// Course
		course.getItems().add(addCourse);
		course.getItems().add(addMajor);
		course.getItems().add(addMinor);
		course.getItems().add(removeCourse);
		course.getItems().add(removeMajor);
		course.getItems().add(removeMinor);
		// Edit
		edit.getItems().add(resetCoursesToPool);
		edit.getItems().add(resetCoursesToSemester);
		// Status
		status.getItems().add(markDoneCourse);
		status.getItems().add(markDoneSemester);
		
		
		EventHandler<ActionEvent> ctrlS = null;
		savePlan.setOnAction(ctrlS);
	}
	
	/**
	 * Just like pressing Ctrl-S in Microsoft Office applications
	 */
	void saveFile() {
		
	}
	
	/**
	 * Similar to saveFile() but will force the application to open explorer to manually save the file.
	 * Similar to some applications that allow shortcut-key: Ctrl-Shift-S.
	 */
	void saveFileAs() {
		
	}
	
	/**
	 * !!!OPTIONAL!!!
	 * Export the content of each semester to the standard academic template provided by the office of First-Year Programs.
	 *  - copy a blank template and place the courses in each semester of the Excel spreadsheet
	 */
	void exportToAcademicTemplate() {
		
	}
	
	/**
	 * Send the content of the plan to a printable, clean, organized format in PDF(Printable Document Format)
	 */
	void printToPDF() {
		
	}
	
	/**
	 * Manually refreshes content of the plan (i.e. refresh GPA calculatiion
	 */
	void refreshPlan() {
		
	}
	
	/**
	 * Populate a new course object and prompt for information to fill in
	 */
	void addCourse() {
		
	}
	
	/**
	 * Open a dialog to prompt user to edit the contents of the currently selected course
	 */
	void editCourse() {
		
	}
	
	/**
	 * Completely remove a course from the current plan.
	 *  - prompt the user asking if this is the correct action to take
	 */
	void removeCourse() {
		
	}
	
	/**
	 * Open window prompting user to select a different degree program to add to current plan.
	 * 	- include cancel/close button to remove window without making changes to the plan
	 */
	void addMajor() {
		
	}
	
	/**
	 * Completely remove a major from the current plan.
	 *  - prompt the user asking if this is the correct action to take
	 *  - if this is the only degree program, make the entire plan empty by removing any minors
	 */
	void removeMajor() {
		
	}
	
	/**
	 * !!!OPTIONAL!!!
	 * Open window prompting user to select a different minor program to add to current plan.
	 * 	- include cancel/close button to remove window without making changes to the plan
	 */
	void addMinor() {
		
	}
	
	/**
	 * !!!OPTIONAL!!!
	 * Completely remove a minor from the current plan.
	 *  - prompt the user asking if this is the correct action to take
	 *  - if there are no currently selected minors, open dialog box telling user there 
	 *  	is no minor to remove
	 */
	void removeMinor() {
		
	}
	
	/**
	 * Reset the current plan to the default list of courses in each semester under the primary major program
	 * 	- any additional classes that belong to other selected majors and minors can be left in the course pool
	 */
	void resetPlanToDefault() {
		
	}
	
	/**
	 * Send all courses in the plan into the course pool (hard reset)
	 * 	- selected majors and minors remain intact
	 */
	void removeAllCourses() {
		
	}
	
	/**
	 * When semesters are marked completed, the semester pool/block changes to different color
	 * 	- GPA recalculated
	 * 	- credits recalculated
	 */
	void markSemesterCompleted() {
		
	}
}
