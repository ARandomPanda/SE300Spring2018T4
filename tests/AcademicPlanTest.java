import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcademicPlanTest {
	
	private AcademicPlan plan;
	private DegreeProgram degree;
	
	@BeforeEach
	void init() {
		plan = new AcademicPlan();
		degree = new DegreeProgram();
		degree.setProgram("Computer Science");
	}
	
	@Test
	void addDegree() {
		assertEquals(true, plan.addDegree(degree));
	}
	
	@Test
	void removeDegree() {
		assertEquals(true, plan.removeDegree(degree));
	}

}
