import java.util.ArrayList;

public class DegreeProgram {

    ArrayList<DegreeRequirement> requirements;

    public DegreeProgram() {
        requirements = new ArrayList<>(40);
    }

    public void addRequirement(DegreeRequirement requirement) {
        requirements.add(requirement);
    }

    public boolean isInProgram(Course course) {
        for (DegreeRequirement r : requirements) {
            if (r.meetsRequirement(course)) {
                return true;
            }
        }

        return false;
    }
}
