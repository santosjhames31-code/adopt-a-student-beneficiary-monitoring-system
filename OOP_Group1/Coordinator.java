package OOP_Group1;

import java.util.ArrayList;
import java.util.Date;

/** Program coordinator: creates and approves adoption assignments. */
public class Coordinator extends Person {

    private static ArrayList<AdoptionAssignment> assignmentList = new ArrayList<>();

    private String assignedProgram;

    public Coordinator(String id, String name, String assignedProgram) {
        super(id, name, "N/A");
        this.assignedProgram = requireText(assignedProgram, "Assigned program");
    }

    public static ArrayList<AdoptionAssignment> getAssignmentList() {
        return new ArrayList<>(assignmentList);
    }

    public String getAssignedProgram() {
        return assignedProgram;
    }

    // ---------- methods from the UML ----------
    public void createAssignment(String adopterId, String beneficiaryId) {
        FacultyAdopter adopter = FacultyAdopter.findById(adopterId);
        StudentBeneficiary student = StudentBeneficiary.findById(beneficiaryId);
        if (adopter == null) {
            throw new IllegalArgumentException("Faculty adopter not found.");
        }
        if (student == null) {
            throw new IllegalArgumentException("Student beneficiary not found.");
        }
        ProgramParticipation participation = student.getCurrentParticipation();
        if (participation == null || !participation.checkEligibility()) {
            throw new IllegalArgumentException("Student must be enrolled in the program first (menu option 10).");
        }
        for (AdoptionAssignment a : assignmentList) {
            if (a.getBeneficiaryId().equals(student.getId()) && !a.checkStatus().equals("Ended")) {
                throw new IllegalArgumentException("This student already has a pending or active assignment.");
            }
        }

        String assignmentId = String.format("ASG-%03d", assignmentList.size() + 1);
        AdoptionAssignment assignment = new AdoptionAssignment(assignmentId, adopter.getId(), student.getId());
        adopter.addAssignment(assignment);
        student.addAssignment(assignment);
        assignmentList.add(assignment);
        System.out.println("Assignment " + assignmentId + " created (Pending). Waiting for approval.");
    }

    public boolean approveAssignment(String assignmentId) {
        for (AdoptionAssignment a : assignmentList) {
            if (a.getAssignmentId().equals(assignmentId) && a.checkStatus().equals("Pending")) {
                a.activate(new Date());
                StudentBeneficiary student = StudentBeneficiary.findById(a.getBeneficiaryId());
                student.updateStatus("Active");
                return true;
            }
        }
        return false;
    }

    public String generateReport() {
        int pending = 0, active = 0, ended = 0, supports = 0, activities = 0;
        for (AdoptionAssignment a : assignmentList) {
            if (a.checkStatus().equals("Pending")) {
                pending++;
            } else if (a.checkStatus().equals("Active")) {
                active++;
            } else {
                ended++;
            }
            supports += a.getSupports().size();
            activities += a.getActivities().size();
        }
        return "========== PROGRAM REPORT ==========\n"
                + "Program: " + assignedProgram + "\n"
                + "Student beneficiaries: " + StudentBeneficiary.getStudentList().size() + "\n"
                + "Faculty adopters: " + FacultyAdopter.getFacultyList().size() + "\n"
                + "Assignments - Pending: " + pending + ", Active: " + active + ", Ended: " + ended + "\n"
                + "Support records: " + supports + "\n"
                + "Monitoring activities: " + activities + "\n"
                + "====================================";
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Program: " + assignedProgram);
    }
}
