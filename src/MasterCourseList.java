import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Christopher McFall
 *
 * A BaseCourse collection that uses the singleton design pattern. Essentially acts as a wrapper for a List
 * List object that is serializeable and a limited interface. Only one object can ever be created, and is accessed
 * with the get() method.
 */
public class MasterCourseList implements Serializable {

    // TODO Serialize UID

    private static final String fileName = "assets/master_course_list.dat";
    private static final File file = new File(fileName);

    // For viewing by the GUI
    private static ObservableList<BaseCourse> courseList;

    private ArrayList<BaseCourse> baseList;

    // To ensure only one will ever be created.
    private static MasterCourseList masterCourseList = null;

    // Private to ensure only one is ever created.
    MasterCourseList() {
        baseList = new ArrayList<>();
    }

    /**
     * If the master course list hasn't been accessed yet, it is initialized. Returns the master course list.
     *
     * @returns the MasterCourseList object
     */
    public static MasterCourseList get() {
        if (file.exists()) {
            if (masterCourseList == null) {
                try {
                    loadData();
                    courseList = FXCollections.observableList(masterCourseList.baseList);
                } catch (IOException e) {
                    System.err.println("Error opening master course list file");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.err.println("Error reading from master course list file");
                    e.printStackTrace();
                }
            }
        } else {
            masterCourseList = new MasterCourseList();
            courseList = FXCollections.observableList(masterCourseList.baseList);
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating master course list file");
                e.printStackTrace();
            }
        }
        return masterCourseList;
    }

    /**
     * Adds a course to the master list and saves the data to the master_course_list.dat file
     * @param course The course to be added.
     */
    public void addCourse(BaseCourse course) {
        courseList.add(course);
        try {
            saveData();
        } catch (IOException e) {
            System.err.println("Error writing to master course list file");
            e.printStackTrace();
        }
    }

    /**
     * Removes a course from the course list if it is there.
     * @param course The course to be removed
     * @return Whether the course specified was in the list before removal
     */
    public boolean removeCourse(BaseCourse course) {
        boolean success = courseList.remove(course);
        try {
            saveData();
        } catch (IOException e) {
            System.err.println("Error saving data");
            e.printStackTrace();
        }

        return success;
    }

    /**
     * @return An immutable ObserverableList view of the master course list
     */
    public ObservableList<BaseCourse> getCourseList() {
        return FXCollections.unmodifiableObservableList(courseList);
    }

    private static void saveData() throws IOException {
        FileOutputStream outStream = new FileOutputStream(file);
        ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
        objOutStream.writeObject(masterCourseList);
        objOutStream.flush();
        objOutStream.close();
    }

    private static void loadData() throws IOException, ClassNotFoundException {
        FileInputStream inStream = new FileInputStream(file);
        ObjectInputStream objInStream = new ObjectInputStream(inStream);
        masterCourseList = (MasterCourseList) objInStream.readObject();
        objInStream.close();
    }
}
