package OOP_Group1;
import java.util.Date;

class AdoptionAssignment{

    private String assignmentId; //genarated from coor
    private String adopterId;    
    private String beneficiaryId;
    private Date startDate;
    private Date endDate;
    private String assignmentStatus;

    AdoptionAssignment(String adopterId, String beneficiaryId, String assignmentId){
        this.adopterId = adopterId;
        this.beneficiaryId = beneficiaryId;
        this.assignmentId = assignmentId;
    }

    public String getAssignmentId(){
        return assignmentId;
    }

    public String getAdopterId(){
        return adopterId;
    }

    public String getBenificiaryId(){
        return beneficiaryId;
    }

    void activate(Date startDate){  
        this.startDate = startDate;
    }

    void end(Date endDate){
        this.endDate = endDate;
    }
    
    String checkStatus(Date date){
        if(startDate == null || date.before(startDate)) assignmentStatus = "Pending";
        else if(endDate != null && date.after(endDate)) assignmentStatus = "Inactive";
        else assignmentStatus = "Active";
        return assignmentStatus;
    }

}
