import java.util.ArrayList;
import java.util.List;

public class FacultyAdopter {
    private String adopterId;
    private String name;
    private String department;
    private String contactNumber;
    private List<StudentBeneficiary> adoptedBeneficiaries;

    public FacultyAdopter(String adopterId, String name, String department, String contactNumber) {
        this.adopterId = adopterId;
        this.name = name;
        this.department = department;
        this.contactNumber = contactNumber;
        this.adoptedBeneficiaries = new ArrayList<>();
    }

    public void registerAdopter() {
        System.out.println("Faculty adopter registered: " + name);
    }

    public void viewAdoptedBeneficiaries() {
        System.out.println("Beneficiaries adopted by " + name + ":");
        for (StudentBeneficiary b : adoptedBeneficiaries) {
            System.out.println("- " + b.getName());
        }
    }

    public void updateProfile(String name, String department, String contactNumber) {
        this.name = name;
        this.department = department;
        this.contactNumber = contactNumber;
    }

    public void addBeneficiary(StudentBeneficiary beneficiary) {
        adoptedBeneficiaries.add(beneficiary);
    }

    public String getAdopterId() {
        return adopterId;
    }

    public String getName() {
        return name;
    }
}
