import java.io.Serializable;

public class Course implements Serializable {

    static final long serialVersionUID = 1L;

    private BaseCourse baseCourse;
    private Grade grade;

    // Disable default constructor
    private Course() {
    }

    public Course(BaseCourse course) {
        if (course == null) {
            throw new NullPointerException();
        }
        baseCourse = course;
        grade = Grade.NONE;
    }

    public BaseCourse getBaseCourse() {
        return this.baseCourse;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public int getNumCredits() {
        return baseCourse.getNumCredits();
    }

    public void setGrade(Grade newGrade) {
        grade = newGrade;
    }
}
