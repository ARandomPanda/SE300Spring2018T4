import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Christopher McFall
 *
 * Data class that stores information about an ERAU course. BaseCourse objects are meant to be kept in a master list
 * to be referenced by courses required by a major, minor, or elective, or by courses planned in an academic plan.
 */
public class BaseCourse implements Serializable, Comparable<BaseCourse> {

    // This keeps the serialization backwards compatable if we add or change methods.
    static final long serialVersionUID = -3027139528909119438L;

    private DepartmentID id;
    private int courseNum;
    private String name;
    private int numCredits;

    private ArrayList<BaseCourse> prereqs;
    private ArrayList<BaseCourse> coreqs;

    // disable default constructor
    public BaseCourse() { }

    /**
     * @throws NullPointerException if ID or name are null
     * @throws IllegalArgumentException if numCredits is not between 0 and 6
     */
    public BaseCourse(DepartmentID id, int courseNum, String name, int numCredits, List<BaseCourse> prereqs, List<BaseCourse> coreqs) {
        setID(id);
        setCourseNum(courseNum);
        setName(name);
        setNumCredits(numCredits);

        if (prereqs == null) {
            this.prereqs = new ArrayList<>(0);
        } else {
            this.prereqs = new ArrayList<>(prereqs);
        }

        if (coreqs == null) {
            this.coreqs = new ArrayList<>(0);
        } else {
            this.coreqs = new ArrayList<>(coreqs);
        }
    }

    /**
     * @throws NullPointerException if ID or name are null
     * @throws IllegalArgumentException if numCredits is not between 0 and 6
     */
    public BaseCourse(DepartmentID id, int courseNum, String name, int numCredits) {
        this(id, courseNum, name, numCredits, null, null);
    }

    public DepartmentID getID() {
        return id;
    }

    public int getCourseNum() {
        return courseNum;
    }

    /**
     * @throws NullPointerException if ID is null
     */
    public void setID(DepartmentID id) {
        if (id == null) {
            throw new NullPointerException();
        }
        this.id = id;
    }

    public void setCourseNum(int courseNum) {
        if (courseNum <= 0) {
            throw new IllegalArgumentException();
        }
        this.courseNum = courseNum;
    }

    public String getName() {
        return name;
    }

    /**
     * @throws NullPointerException if name is null
     */
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public int getNumCredits() {
        return numCredits;
    }

    /**
     * @throws IllegalArgumentException if numCredits is not between 0 and 6
     */
    public void setNumCredits(int numCredits) {
        if (numCredits > 6 || numCredits < 0) {
            throw new IllegalArgumentException("numCredits must be between 0 and 6");
        }
        this.numCredits = numCredits;
    }

    /**
     * @throws NullPointerException if course is null
     */
    public void addPrereq(BaseCourse course) {
        if (course == null) {
            throw new NullPointerException();
        }
        prereqs.add(course);
    }

    /**
     * @throws NullPointerException if course is null
     */
    public void addCoreq(BaseCourse course) {
        if (course == null) {
            throw new NullPointerException();
        }
        coreqs.add(course);
    }

    /**
     * @throws NullPointerException if course is null
     */
    public boolean removePrereq(BaseCourse course) {
        if (course == null) {
            throw new NullPointerException();
        }
        return prereqs.remove(course);
    }

    /**
     * @throws NullPointerException if course is null
     */
    public boolean removeCoreq(BaseCourse course) {
        if (course == null) {
            throw new NullPointerException();
        }
        return coreqs.remove(course);
    }

    public List<BaseCourse> getPrereqs() {
        return Collections.unmodifiableList(prereqs);
    }

    public List<BaseCourse> getCoreqs() {
        return Collections.unmodifiableList(coreqs);
    }

    @Override
    public String toString() {
        return id.toString() + ' ' + courseNum;
    }

    @Override
    public int compareTo(BaseCourse o) {
        if (id == o.id) {
            return Integer.compare(courseNum, o.courseNum);
        } else {
            return id.compareTo(o.id);
        }
    }
}
