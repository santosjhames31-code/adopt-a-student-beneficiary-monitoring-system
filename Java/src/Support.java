public class Support {
    private String supportId;
    private String supportType;
    private String description;
    private String dateGiven;

    public Support(String supportId, String supportType, String description, String dateGiven) {
        this.supportId = supportId;
        this.supportType = supportType;
        this.description = description;
        this.dateGiven = dateGiven;
    }

    public void recordSupport() {
        System.out.println("Support recorded: " + supportType + " on " + dateGiven);
    }

    public void displayDetails() {
        System.out.println("Support ID: " + supportId);
        System.out.println("Type: " + supportType);
        System.out.println("Description: " + description);
        System.out.println("Date given: " + dateGiven);
    }
}
