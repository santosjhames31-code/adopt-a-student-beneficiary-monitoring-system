public class StudentBeneficiary {
    private String beneficiaryId;
    private String name;
    private String yearLevel;
    private String course;
    private String address;

    public StudentBeneficiary(String beneficiaryId, String name, String yearLevel, String course, String address) {
        this.beneficiaryId = beneficiaryId;
        this.name = name;
        this.yearLevel = yearLevel;
        this.course = course;
        this.address = address;
    }

    public void updateProfile(String name, String yearLevel, String course, String address) {
        this.name = name;
        this.yearLevel = yearLevel;
        this.course = course;
        this.address = address;
    }

    public void viewAdopter() {
        System.out.println("Viewing adopter information for beneficiary: " + name);
    }

    public void displayInfo() {
        System.out.println("Beneficiary ID: " + beneficiaryId);
        System.out.println("Name: " + name);
        System.out.println("Year Level: " + yearLevel);
        System.out.println("Course: " + course);
        System.out.println("Address: " + address);
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getName() {
        return name;
    }
}
