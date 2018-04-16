
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcademicPlanTest {
	
	private AcademicPlan plan;
	
	@BeforeEach
	void init() {
		plan = new AcademicPlan();
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
		assertEquals(true, plan.loadPlan("test.aplan"));
	}

}
