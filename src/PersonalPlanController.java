import java.io.File;

public class PersonalPlanController {

    private PersonalPlan plan;

    public PersonalPlanController(PersonalPlan plan) {
        this.plan = plan;
    }

    public void addSemester() {
        plan.addSemester(new Semester());
    }

    public void removeSemester(Semester semester) {
        plan.removeSemester(semester);
    }

    public void addCourse(BaseCourse course, Semester semester) {
        if (plan.getSemesters().contains(semester)) {
            semester.addCourse(course);
        } else {
            throw new IllegalStateException("Attempted to add a course to a semester not in the PersonalPlan");
        }
    }

    public void removeCourse(BaseCourse course, Semester semester) {
        if (plan.getSemesters().contains(semester)) {
            semester.removeCourse(course);
        } else {
            throw new IllegalStateException("Attempted to remove a course to a semester not in the PersonalPlan");
        }
    }
}
