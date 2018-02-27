/**
 * @authors Tyler Warner
 *
 * Menu class holds the methods called by menu commands within the interface. These include, but are 
 * not limited to saving the academic plan, editing the plan, and modifying courses within the plan.
 */
public class ApplicationMenu {

	// Attributes
	// private int tmp = 1;
	
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
