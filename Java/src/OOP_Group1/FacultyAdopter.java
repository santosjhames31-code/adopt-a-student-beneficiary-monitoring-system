package OOP_Group1;
import java.util.ArrayList;

public class FacultyAdopter extends Person{
    private String department;
    private static ArrayList<FacultyAdopter> facultyList = new ArrayList<>();  //list of faculty
    
    FacultyAdopter(String id, String name, String contactNumber, String department){
        super(id, name, contactNumber);
        this.department = department;
        facultyList.add(this);
    }
    FacultyAdopter(String id, String name, String contactNumber){
        super(id, name, contactNumber);
        facultyList.add(this);
    }

    public String getId(){  //returns id
        return super.getId();
    }

    public String getDepartment(){
        return department;
    }

    public void registerAdopter(){
        facultyList.add(this); //store to list
    }

    public void viewAdoptedBenificiaries(){  //malalagyan yung list after activation in COORDINATOR class
        for (StudentBeneficiary student : studentList){
            System.out.println(student.getName());
        }
    }

    public void updateProfile(String department, String contactNumber){
        this.department = department;
        setContactNumber(contactNumber);
    }
}
