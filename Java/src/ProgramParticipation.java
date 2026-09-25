public class ProgramParticipation {
    private String participationId;
    private String semester;
    private String academicYear;
    private String participationStatus;

    public ProgramParticipation(String participationId, String semester, String academicYear) {
        this.participationId = participationId;
        this.semester = semester;
        this.academicYear = academicYear;
        this.participationStatus = "Not enrolled";
    }

    public void enrollInProgram() {
        this.participationStatus = "Enrolled";
        System.out.println("Enrolled in program for " + semester + " " + academicYear);
    }

    public void endParticipation() {
        this.participationStatus = "Ended";
        System.out.println("Participation ended for " + semester + " " + academicYear);
    }

    public boolean checkEligibility() {
        return participationStatus.equals("Enrolled");
    }
}
