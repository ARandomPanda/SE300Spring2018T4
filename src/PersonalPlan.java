import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class PersonalPlan implements Serializable {

    static final long serialVersionUID = 1L;
    private ObservableList<Semester>	semesters = FXCollections.observableArrayList();

    PersonalPlan() { }

    public void addSemester(Semester semester) {
        if (semester == null) {
            throw new NullPointerException();
        }
        semesters.add(semester);
        Collections.sort(semesters);
    }

    public ObservableList<Semester> getSemesterList() {
        return FXCollections.observableArrayList(semesters);
    }
    
    public int getSemesterIndex(Semester semester)
    {
    	int index = 0;
    	
    	for(int i = 0; i<semesters.size(); i++)
    	{
    		Semester activeSemester = semesters.get(i);
    		if (activeSemester.getTerm() == semester.getTerm() && activeSemester.getYear() == semester.getYear())
    		{
    			index = i;
    		}
    	}
    	
    	return index;
    }
    
    public void removeSemester(Semester semester)
    {
        semesters.remove(semester);
    }

    public ObservableList<Semester> getSemesters() {
        return semesters;

    }


}