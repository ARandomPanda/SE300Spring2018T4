import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class MasterCourseList implements Serializable {

    private static String fileName = "master_course_list.dat";
    private static File file = new File(fileName);

    private ObservableList<BaseCourse> courseList;

    private static MasterCourseList masterCourseList = null;

    private MasterCourseList() {
        courseList = FXCollections.observableList(new ArrayList<>());
    }

    public static MasterCourseList get() {
        if (file.exists()) {
            if (masterCourseList == null) {
                try {
                    loadData();
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
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating master course list file");
                e.printStackTrace();
            }
        }
        return masterCourseList;
    }

    public void addCourse(BaseCourse course) {
        courseList.add(course);
        try {
            saveData();
        } catch (IOException e) {
            System.err.println("Error writing to master course list file");
            e.printStackTrace();
        }
    }

    public boolean removeCourse(BaseCourse course) {
        return courseList.remove(course);
    }

    public ObservableList<BaseCourse> getCourseList() {
        return FXCollections.unmodifiableObservableList(courseList);
    }

    private static void saveData() throws IOException {
        System.out.println("Saving");
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
