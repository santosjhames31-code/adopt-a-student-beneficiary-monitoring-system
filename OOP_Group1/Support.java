package OOP_Group1;

/** One piece of support given to a student. */
public class Support {

    private String supportId;
    private String supportType;
    private String description;
    private String dateGiven;

    public Support(String supportType, String description, String dateGiven) {
        if (supportType == null || supportType.trim().isEmpty()) {
            throw new IllegalArgumentException("Support type cannot be empty.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }
        this.supportType = supportType.trim();
        this.description = description.trim();
        this.dateGiven = dateGiven;
    }

    public static String generateId() {
        int total = 0;
        for (AdoptionAssignment a : Coordinator.getAssignmentList()) {
            total += a.getSupports().size();
        }
        return String.format("SUP-%03d", total + 1);
    }

    public String getSupportId() {
        return supportId;
    }

    public String getSupportType() {
        return supportType;
    }

    public String getDescription() {
        return description;
    }

    public String getDateGiven() {
        return dateGiven;
    }

    // ---------- methods from the UML ----------
    public void recordSupport(String supportId) {
        this.supportId = supportId;
    }

    public void displayDetails() {
        System.out.println("[" + supportId + "] " + supportType + ": " + description + " (" + dateGiven + ")");
    }
}
