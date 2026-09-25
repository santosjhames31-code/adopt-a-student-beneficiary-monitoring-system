
public class Main {
    public static void main(String[] args) {
        StudentBeneficiary student = new StudentBeneficiary("B001", "Ana Villanueva", "3rd Year", "BSIT", "Bulacan");
        FacultyAdopter adopter = new FacultyAdopter("A001", "Prof. Santos", "IT Department", "0917-000-0000");
        Coordinator coordinator = new Coordinator("C001", "Ms. Reyes", "Adopt a Student Program");

        adopter.registerAdopter();
        student.displayInfo();

        AdoptionAssignment assignment = coordinator.createAssignment("AS001", "2026-06-01", adopter, student);
        coordinator.approveAssignment("AS001");

        Support support = new Support("S001", "Allowance", "Monthly stipend", "2026-07-01");
        support.recordSupport();

        MonitoringActivity activity = new MonitoringActivity("M001", "Home visit", "2026-08-01", "Doing well academically");
        activity.logActivity();

        BeneficiaryStatus status = new BeneficiaryStatus("ST001", "Active", "2026-08-01");
        status.updateStatus("Active", "Meeting program requirements");

        ProgramParticipation participation = new ProgramParticipation("P001", "1st Semester", "2026-2027");
        participation.enrollInProgram();

        System.out.println(coordinator.generateReport());
    }
}
