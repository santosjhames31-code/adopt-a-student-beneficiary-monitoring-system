import java.util.ArrayList;
import java.util.List;

public class Coordinator {
    private String coordinatorId;
    private String name;
    private String assignedProgram;
    private List<AdoptionAssignment> assignments;

    public Coordinator(String coordinatorId, String name, String assignedProgram) {
        this.coordinatorId = coordinatorId;
        this.name = name;
        this.assignedProgram = assignedProgram;
        this.assignments = new ArrayList<>();
    }

    public AdoptionAssignment createAssignment(String assignmentId, String startDate, FacultyAdopter adopter, StudentBeneficiary beneficiary) {
        AdoptionAssignment assignment = new AdoptionAssignment(assignmentId, startDate, adopter, beneficiary);
        adopter.addBeneficiary(beneficiary);
        assignments.add(assignment);
        System.out.println("Assignment created between " + adopter.getName() + " and " + beneficiary.getName());
        return assignment;
    }

    public void approveAssignment(String assignmentId) {
        for (AdoptionAssignment a : assignments) {
            if (a.getAssignmentId().equals(assignmentId)) {
                a.activate();
                System.out.println("Assignment " + assignmentId + " approved by " + name);
                return;
            }
        }
        System.out.println("Assignment not found: " + assignmentId);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Program Report - ").append(assignedProgram).append("\n");
        report.append("Total assignments: ").append(assignments.size()).append("\n");
        for (AdoptionAssignment a : assignments) {
            report.append("- ").append(a.getAssignmentId())
                  .append(" | Status: ").append(a.checkStatus())
                  .append(" | Beneficiary: ").append(a.getBeneficiary().getName())
                  .append("\n");
        }
        return report.toString();
    }

    public String getName() {
        return name;
    }
}
