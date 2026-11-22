package OOP_Group1;

import java.util.ArrayList;

/** A faculty member who adopts student beneficiaries. */
public class FacultyAdopter extends Person {

    private static ArrayList<FacultyAdopter> facultyList = new ArrayList<>();

    private String department;
    private ArrayList<AdoptionAssignment> assignments = new ArrayList<>();

    public FacultyAdopter(String id, String name, String contactNumber, String department) {
        super(id, name, contactNumber);
        this.department = requireText(department, "Department");
        registerAdopter();
    }

    // ---------- static helpers for the faculty list ----------
    public static ArrayList<FacultyAdopter> getFacultyList() {
        return new ArrayList<>(facultyList);
    }

    public static String generateId() {
        return String.format("FAC-%03d", facultyList.size() + 1);
    }

    public static FacultyAdopter findById(String id) {
        for (FacultyAdopter f : facultyList) {
            if (f.getId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }

    public String getDepartment() {
        return department;
    }

    // ---------- methods from the UML ----------
    public final void registerAdopter() {
        facultyList.add(this);
    }

    public void viewAdoptedBeneficiaries() {
        int count = 0;
        System.out.println("Beneficiaries of " + getName() + ":");
        for (AdoptionAssignment a : assignments) {
            if (a.checkStatus().equals("Active")) {
                StudentBeneficiary s = StudentBeneficiary.findById(a.getBeneficiaryId());
                System.out.println("  - " + s.getName() + " [" + s.getId() + "] " + s.getYearLevel() + " " + s.getCourse());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("  (no active beneficiaries)");
        }
    }

    public void updateProfile(String department, String contactNumber) {
        this.department = requireText(department, "Department");
        setContactNumber(contactNumber);
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Department: " + department);
    }

    void addAssignment(AdoptionAssignment assignment) {
        assignments.add(assignment);
    }
}
