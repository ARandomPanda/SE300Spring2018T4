import java.util.ArrayList;

public class Course {

    private int numCredits;

    private Status status;
    private Grade grade;

    private String name;
    private String ID;

    private ArrayList<Course> prereqs;
    private ArrayList<Course> coreqs;

    private enum Status {
        ATTEMPTED,
        IN_PROGRESS,
        NO_ATTEMPT;
    }
}

