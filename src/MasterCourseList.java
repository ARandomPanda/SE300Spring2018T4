import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterCourseList implements Serializable {

    private static String fileName = "master_course_list.dat";
    private static File file = new File(fileName);

    private ArrayList<BaseCourse> courseList;

    private static MasterCourseList masterCourseList = null;

    private MasterCourseList() {
        courseList = new ArrayList<>();
    }

    public static MasterCourseList get() throws IOException {
        if (file.exists()) {
            if (masterCourseList == null) {
                try {
                    loadData();
                } catch (IOException e) {
                    System.err.println("Error opening master course list file");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.err.println("Error reading from master course list file");
                }
            }
        } else {
            file.createNewFile();
        }
        return masterCourseList;
    }

    public void addCourse(BaseCourse course) {
        courseList.add(course);
    }

    public boolean removeCourse(BaseCourse course) {
        return courseList.remove(course);
    }

    public List<BaseCourse> getCourseList() {
        return Collections.unmodifiableList(courseList);
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
