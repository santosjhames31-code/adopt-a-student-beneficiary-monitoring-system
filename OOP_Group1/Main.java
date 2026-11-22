package OOP_Group1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    // Thrown when the user backs out of a submenu; caught in the main loop so
    // it just cancels the current action instead of crashing the program.
    private static class OperationCancelledException extends RuntimeException {
        OperationCancelledException(String message) { super(message); }
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coordinator coordinator = new Coordinator("COOR-001", "Program Coordinator", "Adopt-A-Student");
        boolean running = true;

        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1": addStudentBeneficiary(sc); break;
                    case "2": addFacultyAdopter(sc); break;
                    case "3": createAssignment(sc, coordinator); break;
                    case "4": approveAssignment(sc, coordinator); break;
                    case "5": viewStudentInfo(sc); break;
                    case "6": viewAdopterBeneficiaries(sc); break;
                    case "7": System.out.println(coordinator.generateReport()); break;
                    case "8": recordSupport(sc); break;
                    case "9": logMonitoringActivity(sc); break;
                    case "10": enrollInProgram(sc); break;
                    case "0":
                        running = false;
                        System.out.println("Exiting. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number from the menu.");
                }
            } catch (OperationCancelledException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n=========== Student Beneficiary Monitoring System ===========");
        System.out.println("1. Add Student Beneficiary");
        System.out.println("2. Add Faculty Adopter");
        System.out.println("3. Create Adoption Assignment");
        System.out.println("4. Approve Adoption Assignment");
        System.out.println("5. View Student Info");
        System.out.println("6. View Adopter's Beneficiaries");
        System.out.println("7. Generate Report");
        System.out.println("8. Record Support for Student");
        System.out.println("9. Log Monitoring Activity for Student");
        System.out.println("10. Enroll Student in Program");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static String requireNonEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        return value.trim();
    }

    private static int requireValidIndex(String input, int size) {
        int idx;
        try {
            idx = Integer.parseInt(input.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number.");
        }
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Invalid selection.");
        }
        return idx;
    }

    // ---------- Year Level submenu ----------
    private static String selectYearLevel(Scanner sc) {
        while (true) {
            System.out.println("Select Year Level:");
            System.out.println("1. Freshmen");
            System.out.println("2. Sophomore");
            System.out.println("3. Junior");
            System.out.println("4. Senior");
            System.out.println("5. Other");
            System.out.println("0. Cancel");
            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": return "Freshmen";
                case "2": return "Sophomore";
                case "3": return "Junior";
                case "4": return "Senior";
                case "5":
                    System.out.print("Enter year level: ");
                    return requireNonEmpty(sc.nextLine(), "Year Level");
                case "0":
                    throw new OperationCancelledException("Add student cancelled.");
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // ---------- Faculty Adopter selection submenu ----------
    private static FacultyAdopter selectFacultyAdopter(Scanner sc, String prompt) {
        ArrayList<FacultyAdopter> list = FacultyAdopter.getFacultyList();
        if (list.isEmpty()) {
            System.out.println("No faculty adopters registered yet.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < list.size(); i++) {
            FacultyAdopter fa = list.get(i);
            System.out.println((i + 1) + ". " + fa.getName() + " [" + fa.getId() + "] - " + fa.getDepartment());
        }
        System.out.println("0. Cancel");
        System.out.print("Choice: ");
        String choice = sc.nextLine().trim();
        if (choice.equals("0")) {
            throw new OperationCancelledException("Cancelled.");
        }
        return list.get(requireValidIndex(choice, list.size()));
    }

    // ---------- Unassigned student selection submenu ----------
    private static StudentBeneficiary selectUnassignedStudent(Scanner sc) {
        ArrayList<StudentBeneficiary> unassigned = new ArrayList<>();
        for (StudentBeneficiary sb : StudentBeneficiary.getStudentList()) {
            if (sb.getCurrentAdopter() == null) unassigned.add(sb);
        }
        if (unassigned.isEmpty()) {
            System.out.println("No unassigned students available.");
            return null;
        }
        System.out.println("Select Student Beneficiary:");
        for (int i = 0; i < unassigned.size(); i++) {
            StudentBeneficiary sb = unassigned.get(i);
            System.out.println((i + 1) + ". " + sb.getName() + " [" + sb.getId() + "] - " + sb.getYearLevel() + " " + sb.getCourse());
        }
        System.out.println("0. Cancel");
        System.out.print("Choice: ");
        String choice = sc.nextLine().trim();
        if (choice.equals("0")) {
            throw new OperationCancelledException("Cancelled.");
        }
        return unassigned.get(requireValidIndex(choice, unassigned.size()));
    }

    // ---------- Any student selection submenu ----------
    private static StudentBeneficiary selectAnyStudent(Scanner sc) {
        ArrayList<StudentBeneficiary> list = StudentBeneficiary.getStudentList();
        if (list.isEmpty()) {
            System.out.println("No students registered yet.");
            return null;
        }
        System.out.println("Select Student:");
        for (int i = 0; i < list.size(); i++) {
            StudentBeneficiary sb = list.get(i);
            System.out.println((i + 1) + ". " + sb.getName() + " [" + sb.getId() + "]");
        }
        System.out.println("0. Cancel");
        System.out.print("Choice: ");
        String choice = sc.nextLine().trim();
        if (choice.equals("0")) {
            throw new OperationCancelledException("Cancelled.");
        }
        return list.get(requireValidIndex(choice, list.size()));
    }

    // ---------- Menu actions ----------

    private static void addStudentBeneficiary(Scanner sc) {
        System.out.print("Name: ");
        String name = requireNonEmpty(sc.nextLine(), "Name");
        System.out.print("Contact Number: ");
        String contact = sc.nextLine().trim();
        String yearLevel = selectYearLevel(sc);
        System.out.print("Course: ");
        String course = sc.nextLine().trim();
        System.out.print("Address: ");
        String address = sc.nextLine().trim();

        String id = StudentBeneficiary.generateId();
        new StudentBeneficiary(id, name, contact, yearLevel, course, address, "Pending");
        System.out.println("Student beneficiary added successfully. Assigned ID: " + id);
    }

    private static void addFacultyAdopter(Scanner sc) {
        System.out.print("Name: ");
        String name = requireNonEmpty(sc.nextLine(), "Name");
        System.out.print("Contact Number: ");
        String contact = sc.nextLine().trim();
        System.out.print("Department: ");
        String department = sc.nextLine().trim();

        String id = FacultyAdopter.generateId();
        new FacultyAdopter(id, name, contact, department);
        System.out.println("Faculty adopter added successfully. Assigned ID: " + id);
    }

    private static void createAssignment(Scanner sc, Coordinator coordinator) {
        FacultyAdopter adopter = selectFacultyAdopter(sc, "Select Faculty Adopter:");
        if (adopter == null) return;
        StudentBeneficiary student = selectUnassignedStudent(sc);
        if (student == null) return;

        coordinator.createAssignment(adopter.getId(), student.getId());
    }

    private static void approveAssignment(Scanner sc, Coordinator coordinator) {
        ArrayList<AdoptionAssignment> pending = new ArrayList<>();
        for (AdoptionAssignment a : Coordinator.getAssignmentList()) {
            if ("Pending".equals(a.getAssignmentStatus())) pending.add(a);
        }
        if (pending.isEmpty()) {
            System.out.println("No pending assignments to approve.");
            return;
        }

        System.out.println("Pending Assignments:");
        for (int i = 0; i < pending.size(); i++) {
            AdoptionAssignment a = pending.get(i);
            StudentBeneficiary sb = StudentBeneficiary.findById(a.getBeneficiaryId());
            FacultyAdopter fa = FacultyAdopter.findById(a.getAdopterId());
            String studentName = (sb != null) ? sb.getName() : a.getBeneficiaryId();
            String adopterName = (fa != null) ? fa.getName() : a.getAdopterId();
            System.out.println((i + 1) + ". [" + a.getAssignmentId() + "] Student: " + studentName + "  |  Adopter: " + adopterName);
        }
        System.out.println("0. Cancel");
        System.out.print("Select assignment to approve: ");
        String choice = sc.nextLine().trim();
        if (choice.equals("0")) {
            System.out.println("Approval cancelled.");
            return;
        }
        AdoptionAssignment selected = pending.get(requireValidIndex(choice, pending.size()));
        boolean approved = coordinator.approveAssignment(selected.getAssignmentId());
        System.out.println(approved ? "Assignment approved and activated." : "Approval failed.");
    }

    private static void viewStudentInfo(Scanner sc) {
        StudentBeneficiary sb = selectAnyStudent(sc);
        if (sb == null) return;
        sb.displayInfo();
        sb.viewAdopter();

        System.out.println("Support Records:");
        if (sb.getSupportRecords().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Support s : sb.getSupportRecords()) {
                System.out.println("  - [" + s.getSupportId() + "] " + s.getSupportType() + ": " + s.getDescription() + " (" + s.getDateGiven() + ")");
            }
        }

        System.out.println("Monitoring Activities:");
        if (sb.getMonitoringActivities().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (MonitoringActivity m : sb.getMonitoringActivities()) {
                System.out.println("  - [" + m.getActivityId() + "] " + m.getActivityType() + " on " + DATE_FORMAT.format(m.getDateConducted()) + " - " + m.getRemarks());
            }
        }

        ProgramParticipation current = sb.getCurrentParticipation();
        System.out.println("Program Participation:");
        if (current == null) {
            System.out.println("  Not enrolled in any program yet.");
        } else {
            System.out.println("  [" + current.getParticipationId() + "] " + current.getSemester() + " " + current.getAcademicYear()
                    + " - Status: " + current.getParticipationStatus() + " (Eligible: " + current.checkEligibility() + ")");
        }
    }

    private static void viewAdopterBeneficiaries(Scanner sc) {
        FacultyAdopter fa = selectFacultyAdopter(sc, "Select Faculty Adopter:");
        if (fa == null) return;
        fa.viewAdoptedBeneficiaries();
    }

    private static void recordSupport(Scanner sc) {
        StudentBeneficiary sb = selectAnyStudent(sc);
        if (sb == null) return;

        System.out.print("Support Type (e.g. Financial, School Supplies, Meals): ");
        String type = requireNonEmpty(sc.nextLine(), "Support Type");
        System.out.print("Description: ");
        String description = requireNonEmpty(sc.nextLine(), "Description");

        String dateGiven = DATE_FORMAT.format(new Date());
        Support support = new Support(type, description, dateGiven);
        support.recordSupport(Support.generateId());
        sb.addSupport(support);

        System.out.println("Support recorded for " + sb.getName() + ". ID: " + support.getSupportId());
    }

    private static void logMonitoringActivity(Scanner sc) {
        StudentBeneficiary sb = selectAnyStudent(sc);
        if (sb == null) return;

        System.out.print("Activity Type (e.g. Home Visit, Grade Check, Call): ");
        String type = requireNonEmpty(sc.nextLine(), "Activity Type");
        System.out.print("Remarks: ");
        String remarks = sc.nextLine().trim();

        MonitoringActivity activity = new MonitoringActivity(MonitoringActivity.generateId());
        activity.logActivity(type, new Date(), remarks);
        sb.addMonitoringActivity(activity);

        System.out.println("Monitoring activity logged for " + sb.getName() + ". ID: " + activity.getActivityId());
    }

    private static void enrollInProgram(Scanner sc) {
        StudentBeneficiary sb = selectAnyStudent(sc);
        if (sb == null) return;

        System.out.print("Semester (e.g. 1st Semester): ");
        String semester = requireNonEmpty(sc.nextLine(), "Semester");
        System.out.print("Academic Year (e.g. 2026-2027): ");
        String academicYear = requireNonEmpty(sc.nextLine(), "Academic Year");

        ProgramParticipation participation = new ProgramParticipation(ProgramParticipation.generateId());
        participation.enrollInProgram(semester, academicYear);
        sb.addProgramParticipation(participation);

        System.out.println(sb.getName() + " enrolled successfully. ID: " + participation.getParticipationId());
    }
}
