import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

class AcademicPlanTest {
	
	private AcademicPlan testPlan = new AcademicPlan();
    private static final MasterCourseList masterCourseList = MasterCourseList.get();
    private ObservableList<BaseCourse> testCourseList = masterCourseList.getCourseList();
    private PersonalPlan testPersonalPlan = new PersonalPlan();
    private BaseCourse testBaseCourse;
    private Course testCourse, testCourse2;
    private Semester testSemester;
	
	@BeforeEach
	void populateStuff () {
		
		testBaseCourse = testCourseList.get(0);
		testCourse = new Course(testBaseCourse);
		masterCourseList.getCourseList().get(0);
		testPlan.addCourse(testCourse);
		
		testBaseCourse = testCourseList.get(1);
		testCourse2 = new Course(testBaseCourse);
		testSemester = new Semester(Term.SPRING, 2016);
		testSemester.addCourse(testCourse2);
		testPersonalPlan.addSemester(testSemester);
	}
	
	@Test
	void changePlanFileLocation () {
		String inputURL = "asset/temporary";
		testPlan.setPlanSaveLocation(inputURL);
		assertEquals(inputURL, testPlan.getPlanSaveLocation());
		
	}
	
	@Test
	void savePlan() {
		testPlan.setPlanSaveLocation("assets/test.aplan");
		assertEquals(true, testPlan.savePlan());
	}
	
	@Test
	void loadPlan() {
		testPlan.savePlan();
		AcademicPlan plantmp = AcademicPlan.loadPlan("assets/test.aplan");
		assertTrue(plantmp.getClass() == AcademicPlan.class);
	}
	
	@Test
	void calculateGPA () {
		double eps = Math.pow(1, -15);
		boolean condition = testPlan.calculateCreditsAndGPA() > (0.0-eps) && testPlan.calculateCreditsAndGPA() < (4.0+eps);
		assertTrue(condition);
	}
	
	@Test
	void catalogYear () {
		assertTrue(testPlan.getCatalogYear() > 2000 && testPlan.getCatalogYear() < 3000);
	}
	
	@Test
	void moveCourseToSemesterAndBack () {
		assertTrue(testPlan.moveCourseToSemester(testSemester, testCourse));
		assertTrue(testPlan.moveCourseToCoursePool(testSemester, testCourse));
	}

}
