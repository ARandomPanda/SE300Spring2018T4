	import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcademicPlanTest {
	
	private AcademicPlan plan;
	private DegreeProgram degree;
	
	@BeforeEach
	void init() {
		plan = new AcademicPlan();
		degree = new DegreeProgram();
		//degree.setProgram("Computer Science");
	}
	
	@Test
	void changePlanFileLocation () {
		String inputURL = "asset/temporary";
		plan.setPlanSaveLocation(inputURL);
		assertEquals(inputURL, plan.getPlanSaveLocation());
		
	}
	
	@Test
	void savePlan() {
		assertEquals(true, plan.savePlan());
	}
	
	@Test
	void loadPlan() {
		plan.savePlan();
		assertEquals(true, plan.loadPlan());
	}
	
	@Test
	void calculateGPA() {
		double epsilon = Math.pow(10, -15); //10^(-15)
		double high = 4.0 + epsilon, low = 0.0 - epsilon;
		//assertTrue("Error, random is too high", plan.calculateGPA() >= high);
		//assertTrue("Error, random is too low",  plan.calculateGPA() <= low);
	}
	
	@Test
	void calculateCredits() {
		int low = 0;
		//assertTrue("Credits are too low", plan.calculateCredits() < low);
	}

}
