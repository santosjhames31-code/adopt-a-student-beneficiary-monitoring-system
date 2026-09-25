public class MonitoringActivity {
    private String activityId;
    private String activityType;
    private String dateConducted;
    private String remarks;

    public MonitoringActivity(String activityId, String activityType, String dateConducted, String remarks) {
        this.activityId = activityId;
        this.activityType = activityType;
        this.dateConducted = dateConducted;
        this.remarks = remarks;
    }

    public void logActivity() {
        System.out.println("Monitoring activity logged: " + activityType + " on " + dateConducted);
    }

    public void displaySummary() {
        System.out.println("Activity ID: " + activityId);
        System.out.println("Type: " + activityType);
        System.out.println("Date conducted: " + dateConducted);
        System.out.println("Remarks: " + remarks);
    }
}
