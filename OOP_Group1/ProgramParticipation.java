package OOP_Group1;

/**
 * A student's enrollment record for one term.
 * Status: Not Enrolled -> Enrolled -> Ended
 */
public class ProgramParticipation {

    private String participationId;
    private String semester;
    private String academicYear;
    private String participationStatus;

    public ProgramParticipation(String participationId) {
        this.participationId = participationId;
        this.participationStatus = "Not Enrolled";
    }

    public static String generateId() {
        int total = 0;
        for (StudentBeneficiary s : StudentBeneficiary.getStudentList()) {
            total += s.getParticipationCount();
        }
        return String.format("PRT-%03d", total + 1);
    }

    public String getParticipationId() {
        return participationId;
    }

    public String getSemester() {
        return semester;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getParticipationStatus() {
        return participationStatus;
    }

    // ---------- methods from the UML ----------
    public void enrollInProgram(String semester, String academicYear) {
        if (semester == null || semester.trim().isEmpty()) {
            throw new IllegalArgumentException("Semester cannot be empty.");
        }
        if (academicYear == null || !academicYear.trim().matches("\\d{4}-\\d{4}")) {
            throw new IllegalArgumentException("Academic year must look like 2026-2027.");
        }
        this.semester = semester.trim();
        this.academicYear = academicYear.trim();
        this.participationStatus = "Enrolled";
    }

    public void endParticipation() {
        if (!participationStatus.equals("Enrolled")) {
            throw new IllegalArgumentException("Only an enrolled participation can be ended.");
        }
        this.participationStatus = "Ended";
    }

    public boolean checkEligibility() {
        return participationStatus.equals("Enrolled");
    }
}
