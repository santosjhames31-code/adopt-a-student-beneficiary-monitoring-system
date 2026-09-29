package OOP_Group1;
import java.util.ArrayList;

public class Coordinator extends Person{
    private String assignedProgram; 
    private static ArrayList <AdoptionAssignment> assignmentList = new ArrayList<>(); 

    Coordinator(String id, String name, String assignedProgram){
        super(id, name, null);
        this.assignedProgram = assignedProgram;
    }

    // params: adopterID from FA, beneficiaryID from SB 
    public void createAssignment(String adopterID, String beneficiaryID){
        assignmentList.add(new AdoptionAssignment(adopterID, beneficiaryID));
    }

    public boolean approveAssignment(String assignmentID){ //assignment ID from Adoption Assignment class, will check if mag mamatch
        return true;
    }

    public void generateReport(){ // use api to generate

    }   
}
