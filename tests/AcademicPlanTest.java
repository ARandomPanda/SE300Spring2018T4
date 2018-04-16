import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AcademicPlanTest {
	
	private AcademicPlan plan = new AcademicPlan();
	
	@Test
	void changePlanFileLocation () {
		String inputURL = "asset/temporary";
		plan.setPlanSaveLocation(inputURL);
		assertEquals(inputURL, plan.getPlanSaveLocation());
		
	}
	
	@Test
	void savePlan() {
		plan.setPlanSaveLocation("assets/test.aplan");
		assertEquals(true, plan.savePlan());
	}
	
	@Test
	void loadPlan() {
		
		
		plan.savePlan();
		AcademicPlan plantmp = plan.loadPlan("assets/test.aplan");
		assertTrue(plantmp.getClass() == AcademicPlan.class);
	}
	
	@Test
	void calculateGPA () {
		double eps = Math.pow(1, -15);
		boolean condition = plan.calculateCreditsAndGPA() > (0.0-eps) && plan.calculateCreditsAndGPA() < (4.0+eps);
		assertTrue(condition);
	}
	
	@Test
	void catalogYear () {
		assertTrue(plan.getCatalogYear() > 2000 && plan.getCatalogYear() < 3000);
	}

}
