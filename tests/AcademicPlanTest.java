import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcademicPlanTest {

	private DegreeProgram degA, degB, degC;
	private ArrayList<DegreeProgram> degrees;
	
	@BeforeEach
	void init() {
		degA = new DegreeProgram("Computer Science");
		degB = new DegreeProgram("Software Engineering");
		degC = new DegreeProgram("Computer Engineering");
		degrees.add(degA);
		degrees.add(degB);
		degrees.add(degC);
	}
	
	@Test
	void addDegree() {
		assertEquals(true, degrees.contains(degA));
		assertEquals(true, degrees.contains(degB));
		assertEquals(true, degrees.contains(degC));
	}

}
