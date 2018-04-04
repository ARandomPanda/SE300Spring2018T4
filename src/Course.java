
public class Course {

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

    public int getNumCreadits() {
        return baseCourse.getNumCredits();
    }
    public void setGrade(Grade newGrade) {
        grade = newGrade;
    }
}
