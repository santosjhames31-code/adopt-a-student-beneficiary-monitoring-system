package OOP_Group1;

import java.text.SimpleDateFormat;
import java.util.Date;

/** One monitoring check-in done on a student. */
public class MonitoringActivity {

    private String activityId;
    private String activityType;
    private Date dateConducted;
    private String remarks;

    public MonitoringActivity(String activityId) {
        this.activityId = activityId;
    }

    public static String generateId() {
        int total = 0;
        for (AdoptionAssignment a : Coordinator.getAssignmentList()) {
            total += a.getActivities().size();
        }
        return String.format("ACT-%03d", total + 1);
    }

    public String getActivityId() {
        return activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public Date getDateConducted() {
        return dateConducted;
    }

    public String getRemarks() {
        return remarks;
    }

    // ---------- methods from the UML ----------
    public void logActivity(String activityType, Date dateConducted, String remarks) {
        if (activityType == null || activityType.trim().isEmpty()) {
            throw new IllegalArgumentException("Activity type cannot be empty.");
        }
        if (dateConducted == null) {
            throw new IllegalArgumentException("Date conducted is required.");
        }
        this.activityType = activityType.trim();
        this.dateConducted = dateConducted;
        this.remarks = (remarks == null) ? "" : remarks.trim();
    }

    public void displaySummary() {
        System.out.println("[" + activityId + "] " + activityType + " on "
                + new SimpleDateFormat("yyyy-MM-dd").format(dateConducted) + " - " + remarks);
    }
}
