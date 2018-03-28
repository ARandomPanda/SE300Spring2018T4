/**
 * @author Christopher Mcfall
 */
public enum Grade {
    A(4),
    B(3),
    C(2),
    D(1),
    F(0),
    I(-1),
    W(-1),
    NONE(-1);

    private int gradeValue;
    private char courseCredits;
    
    private Grade(int gradeValue) {
        this.gradeValue = gradeValue;
    }
    
    protected void setCourseCredits(char credits) {
    	this.courseCredits = credits;
    }
    
    protected int gpaCredits() {
    	return gradeValue * courseCredits;
    }

    /**
     * @return The value of a grade on a 4.0 GPA scale. -1 indicates the value should not be included in GPA
     *      calculations
     */
    public int getGradeValue() {
        return this.gradeValue;
    }
    
    /**
     * @return The number of credits in the current course from 1 to 6.
     */
    public char getCourseCredits () {
    	return this.courseCredits;
    }
}
