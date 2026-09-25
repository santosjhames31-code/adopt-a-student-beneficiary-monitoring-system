public class AdoptionAssignment {
    private String assignmentId;
    private String startDate;
    private String endDate;
    private String assignmentStatus;
    private FacultyAdopter adopter;
    private StudentBeneficiary beneficiary;

    public AdoptionAssignment(String assignmentId, String startDate, FacultyAdopter adopter, StudentBeneficiary beneficiary) {
        this.assignmentId = assignmentId;
        this.startDate = startDate;
        this.assignmentStatus = "Pending";
        this.adopter = adopter;
        this.beneficiary = beneficiary;
    }

    public void activate() {
        this.assignmentStatus = "Active";
        System.out.println("Assignment " + assignmentId + " is now active.");
    }

    public void end() {
        this.assignmentStatus = "Ended";
        System.out.println("Assignment " + assignmentId + " has ended.");
    }

    public String checkStatus() {
        return assignmentStatus;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public FacultyAdopter getAdopter() {
        return adopter;
    }

    public StudentBeneficiary getBeneficiary() {
        return beneficiary;
    }
}
