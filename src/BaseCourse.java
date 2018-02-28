import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseCourse implements Serializable {

    // This keeps the serialization backwards compatable if we add or change methods.
    static final long serialVersionUID = -3027139528909119438L;

    private String ID;
    private String name;
    private int numCredits;

    private ArrayList<BaseCourse> prereqs;
    private ArrayList<BaseCourse> coreqs;

    // disable default constructor
    private BaseCourse() { };

    public BaseCourse(String ID, String name, int numCredits, List<BaseCourse> prereqs, List<BaseCourse> coreqs) {
        setID(ID);
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

    public BaseCourse(String ID, String name, int numCredits) {
        this(ID, name, numCredits, null, null);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        if (numCredits > 6 || numCredits < 0) {
            throw new IllegalArgumentException("numCredits must be between 0 and 6");
        }
        this.numCredits = numCredits;
    }

    public void addPrereq(BaseCourse course) {
        prereqs.add(course);
    }

    public void addCoreq(BaseCourse course) {
        coreqs.add(course);
    }

    public boolean removePrereq(BaseCourse course) {
        return prereqs.remove(course);
    }

    public boolean removeCoreq(BaseCourse course) {
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
        return this.getID() + "\t\t" + this.getName();
    }
}
