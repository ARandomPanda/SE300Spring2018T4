import java.io.Serializable;
import java.util.ArrayList;

public class RequiredCourseOption implements Serializable, DegreeRequirement {

    static final long serialVersionUID = 1L;

    private ArrayList<BaseCourse> requirementOptions;

    private RequiredCourseOption(BaseCourse ... course) {
        requirementOptions = new ArrayList<>(course.length);
        for (BaseCourse c : course) {
            requirementOptions.add(c);
        }
    }

    @Override
    public boolean meetsRequirement(Course course) {
        for (BaseCourse c : requirementOptions) {
            if (c == course.getBaseCourse()) {
                return true;
            }
        }

        return false;
    }
}
