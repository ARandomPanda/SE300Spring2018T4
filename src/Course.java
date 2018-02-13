import java.util.ArrayList;
import java.util.List;

public class Course {

    private int numCredits;

    private Status status;
    private Grade grade;

    private String name;
    private String ID;

    private ArrayList<Course> prereqs;
    private ArrayList<Course> coreqs;

    // effectively disable default constructor
    private Course() {}

    public Course(String ID, String name, int numCredits, List<Course> prereqs, List<Course> coreqs) {
        if (ID == null || name == null) {
            throw new NullPointerException();
        }
        if (numCredits < 0 || numCredits > 6) {
            throw new IllegalArgumentException("Number of credits must be between 0 and 6");
        }
        this.numCredits = numCredits;
        this.ID = ID;
        this.name = name;
        this.grade = Grade.NONE;
        this.status = Status.NO_ATTEMPT;

        if (prereqs == null) {
            this.prereqs = new ArrayList<>(0);
        } else {
            this.prereqs = new ArrayList<>(prereqs);
        }

        if (coreqs == null) {
            this.prereqs = new ArrayList<>(0);
        } else {
            this.coreqs = new ArrayList<>(coreqs);
        }
    }

    public Course(String ID, String name, int numCredits) {
        this(ID, name, numCredits, null, null);
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        if (numCredits < 0 || numCredits > 6) {
            throw new IllegalArgumentException("Number of credits must be between 0 and 6");
        }
        this.numCredits = numCredits;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        if (grade == Grade.NONE)
            return;
        status = Status.ATTEMPTED;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if (ID == null) {
            throw new NullPointerException();
        }
        this.ID = ID;
    }

    public Course[] getPrereqs() {
        return prereqs.toArray(new Course[0]);
    }

    public Course[] getCoreqs() {
        return coreqs.toArray(new Course[0]);
    }

    public void addPrereq(Course newPrereq) {
        if (newPrereq == null) {
            throw new NullPointerException();
        }
        prereqs.add(newPrereq);
    }

    public void addCoreq(Course newCoreq) {
        if (newCoreq == null) {
            throw new NullPointerException();
        }
        coreqs.add(newCoreq);
    }

    public void removePrereq(Course prereq) {
        if (prereq == null) {
            throw new NullPointerException();
        }
        prereqs.remove(prereq);
    }

    public void removeCoreq(Course coreq) {
        if (coreq == null) {
            throw new NullPointerException();
        }
        coreqs.remove(coreq);
    }

    public void setAttempted() {
        this.status = Status.ATTEMPTED;
    }

    public void setInProgress() {
        this.status = Status.IN_PROGRESS;
    }

    public void setNoAttempt() {
        this.status = Status.NO_ATTEMPT;
    }

    public boolean isAttempted() {
        return status == Status.ATTEMPTED;
    }

    public boolean isInProgress() {
        return status == Status.IN_PROGRESS;
    }

    public boolean isUnattempted() {
        return status == Status.NO_ATTEMPT;
    }

    private enum Status {
        ATTEMPTED,
        IN_PROGRESS,
        NO_ATTEMPT;
    }
}

