import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * @author Tyler Warner
 * 
 * Menu class holds the methods called by menu commands within the interface. These include, but are 
 * not limited to saving the academic plan, editing the plan, and modifying courses within the plan.
 */
public class ApplicationMenu {

	MenuBar menuBar = new MenuBar();

	// Menu tabs
	Menu file,semester , course, edit, status;
	// File
	MenuItem savePlan, saveasPlan, loadPlan, exportPlan, printPlan, refreshPlan;
	//Semester
	MenuItem addSemester, removeSemester;
	// Course
	MenuItem addCourse, addMajor, addMinor, removeCourse, removeMajor, removeMinor;
	// Edit
	MenuItem resetCoursesToPool, resetCoursesToSemester;
	// Status
	MenuItem markDoneCourse, markDoneSemester;

	public ApplicationMenu() {
		initializeConstants();
		addMenuItemsToMenus();
		addMenusToMenubar();
	}

	private void addMenusToMenubar() {
		menuBar.getMenus().add(file);
		menuBar.getMenus().add(semester);
		menuBar.getMenus().add(course);
		menuBar.getMenus().add(edit);
		menuBar.getMenus().add(status);
	}

	private void addMenuItemsToMenus() {
		// File 	
		file.getItems().add(savePlan);
		file.getItems().add(saveasPlan);
		file.getItems().add(loadPlan);
		file.getItems().add(exportPlan);
		file.getItems().add(printPlan);
		file.getItems().add(refreshPlan);

		//Semester
		semester.getItems().add(addSemester);
		semester.getItems().add(removeSemester);

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
	}

	private void initializeConstants() {
		file = new Menu("File");
		semester = new Menu("Semester");
		course = new Menu("Course");
		edit = new Menu("Edit");
		status = new Menu("Status");

		addSemester = new MenuItem("Add Semester");
		removeSemester = new MenuItem("Remove Semester");

		savePlan = new MenuItem("Save");
		saveasPlan = new MenuItem("Save as");
		loadPlan = new MenuItem("Load");
		exportPlan = new MenuItem("Export");
		printPlan = new MenuItem("Print");
		refreshPlan = new MenuItem("Refresh Plan");


		addCourse = new MenuItem("Add Course");
		addMajor = new MenuItem("Add Major");
		addMinor = new MenuItem("Add Minor");
		removeCourse = new MenuItem("Remove Course");
		removeMajor = new MenuItem("Remove Major");
		removeMinor = new MenuItem("Remove Minor");

		resetCoursesToPool = new MenuItem("Send Courses to Pool");
		resetCoursesToSemester = new MenuItem("Reset to Default");

		markDoneCourse = new MenuItem("Mark Course Completed");
		markDoneSemester = new MenuItem("Mark Entire Semester Completed");
	}

	public MenuBar getMenuBar()
	{
		return menuBar;
	}	

}