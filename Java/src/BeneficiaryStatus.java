public class BeneficiaryStatus {
    private String statusId;
    private String currentStatus;
    private String dateUpdated;
    private String reason;

    public BeneficiaryStatus(String statusId, String currentStatus, String dateUpdated) {
        this.statusId = statusId;
        this.currentStatus = currentStatus;
        this.dateUpdated = dateUpdated;
        this.reason = "";
    }

    public void updateStatus(String status, String reason) {
        this.currentStatus = status;
        this.reason = reason;
        System.out.println("Status updated to: " + status);
    }

    public String getCurrentStatus() {
        return currentStatus;
    }
}
