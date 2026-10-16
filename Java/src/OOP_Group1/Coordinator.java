package OOP_Group1;
import java.util.ArrayList;


public class Coordinator extends Person{
    private String assignedProgram; 
    private String assignmentID;
    private FacultyAdopter fa;
    private StudentBeneficiary sb;
    private static int assignment_count = 0;
    private static ArrayList <AdoptionAssignment> assignmentList = new ArrayList<>(); 

    Coordinator(String id, String name, String assignedProgram){
        super(id, name, null);
        this.assignedProgram = assignedProgram;
    }

    // params: adopterID from FA, beneficiaryID from SB 
    public void createAssignment(String adopterID, String beneficiaryID){
        String assignmentId = "ASSID - " + assignment_count++;
        assignmentList.add(new AdoptionAssignment(fa.getId(), sb.getId(), assignmentId));
        
    }

    public boolean approveAssignment(String assignmentID){ //assignment ID from Adoption Assignment class, will check if mag mamatch
        return true;
    }

    public void generateReport(){ // use api to generate

    }   
}
