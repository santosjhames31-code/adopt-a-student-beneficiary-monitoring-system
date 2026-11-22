package OOP_Group1;

import java.util.ArrayList;
import java.util.Date;

/**
 * Connects one FacultyAdopter to one StudentBeneficiary.
 * Owns its Support and MonitoringActivity records (composition).
 * Status: Pending -> Active -> Ended
 */
public class AdoptionAssignment {

    private String assignmentId;
    private String adopterId;
    private String beneficiaryId;
    private Date startDate;
    private Date endDate;
    private String assignmentStatus;

    private ArrayList<Support> supports = new ArrayList<>();
    private ArrayList<MonitoringActivity> activities = new ArrayList<>();

    public AdoptionAssignment(String assignmentId, String adopterId, String beneficiaryId) {
        this.assignmentId = assignmentId;
        this.adopterId = adopterId;
        this.beneficiaryId = beneficiaryId;
        this.assignmentStatus = "Pending";
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getAdopterId() {
        return adopterId;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    // ---------- methods from the UML ----------
    public void activate(Date startDate) {
        if (!assignmentStatus.equals("Pending")) {
            throw new IllegalArgumentException("Only a pending assignment can be activated.");
        }
        this.startDate = startDate;
        this.assignmentStatus = "Active";
    }

    public void end(Date endDate) {
        if (!assignmentStatus.equals("Active")) {
            throw new IllegalArgumentException("Only an active assignment can be ended.");
        }
        this.endDate = endDate;
        this.assignmentStatus = "Ended";
    }

    public String checkStatus() {
        return assignmentStatus;
    }

    // ---------- composition: records that belong to this assignment ----------
    public void addSupport(Support support) {
        supports.add(support);
    }

    public void addMonitoringActivity(MonitoringActivity activity) {
        activities.add(activity);
    }

    public ArrayList<Support> getSupports() {
        return new ArrayList<>(supports);
    }

    public ArrayList<MonitoringActivity> getActivities() {
        return new ArrayList<>(activities);
    }
}
