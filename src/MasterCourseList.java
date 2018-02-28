import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class MasterCourseList implements Serializable {

    private static String fileName = "assets/master_course_list.dat";
    private static File file = new File(fileName);

    private static ObservableList<BaseCourse> courseList;

    private ArrayList<BaseCourse> baseList;

    private static MasterCourseList masterCourseList = null;

    private MasterCourseList() {
        baseList = new ArrayList<>();
    }

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
        boolean success = courseList.remove(course);
        try {
            saveData();
        } catch (IOException e) {
            System.err.println("Error saving data");
            e.printStackTrace();
        }

        return success;
    }

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
