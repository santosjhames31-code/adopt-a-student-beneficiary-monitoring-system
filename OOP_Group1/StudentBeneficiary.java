package OOP_Group1;

import java.util.ArrayList;

/** A student who receives support from the Adopt-A-Student program. */
public class StudentBeneficiary extends Person {

    private static ArrayList<StudentBeneficiary> studentList = new ArrayList<>();

    private String yearLevel;
    private String course;
    private String address;
    private String currentStatus;

    // Relationships (see UMLRelationship)
    private ArrayList<ProgramParticipation> participations = new ArrayList<>();
    private ArrayList<AdoptionAssignment> assignments = new ArrayList<>();

    public StudentBeneficiary(String id, String name, String contactNumber,
                              String yearLevel, String course, String address, String currentStatus) {
        super(id, name, contactNumber);
        this.yearLevel = requireText(yearLevel, "Year level");
        this.course = requireText(course, "Course");
        this.address = requireText(address, "Address");
        this.currentStatus = requireText(currentStatus, "Status");
        studentList.add(this);
    }

    // ---------- static helpers for the student list ----------
    public static ArrayList<StudentBeneficiary> getStudentList() {
        return new ArrayList<>(studentList);
    }

    public static String generateId() {
        return String.format("STU-%03d", studentList.size() + 1);
    }

    public static StudentBeneficiary findById(String id) {
        for (StudentBeneficiary s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // ---------- getters ----------
    public String getYearLevel() {
        return yearLevel;
    }

    public String getCourse() {
        return course;
    }

    public String getAddress() {
        return address;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    // ---------- methods from the UML ----------
    public void updateProfile(String address, String yearLevel, String course) {
        this.address = requireText(address, "Address");
        this.yearLevel = requireText(yearLevel, "Year level");
        this.course = requireText(course, "Course");
    }

    public void updateStatus(String status) {
        this.currentStatus = requireText(status, "Status");
    }

    public void viewAdopter() {
        FacultyAdopter adopter = getCurrentAdopter();
        if (adopter == null) {
            System.out.println("Adopter: none assigned yet");
        } else {
            System.out.println("Adopter: " + adopter.getName() + " (" + adopter.getDepartment() + ")");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Year Level: " + yearLevel);
        System.out.println("Course: " + course);
        System.out.println("Address: " + address);
        System.out.println("Status: " + currentStatus);
    }

    // ---------- relationship methods ----------
    void addAssignment(AdoptionAssignment assignment) {
        assignments.add(assignment);
    }

    private AdoptionAssignment getActiveAssignment() {
        for (AdoptionAssignment a : assignments) {
            if (a.checkStatus().equals("Active")) {
                return a;
            }
        }
        return null;
    }

    public FacultyAdopter getCurrentAdopter() {
        AdoptionAssignment active = getActiveAssignment();
        if (active == null) {
            return null;
        }
        return FacultyAdopter.findById(active.getAdopterId());
    }

    // Support and monitoring belong to the student's ACTIVE assignment (composition)
    public void addSupport(Support support) {
        requireActiveAssignment().addSupport(support);
    }

    public void addMonitoringActivity(MonitoringActivity activity) {
        requireActiveAssignment().addMonitoringActivity(activity);
    }

    private AdoptionAssignment requireActiveAssignment() {
        AdoptionAssignment active = getActiveAssignment();
        if (active == null) {
            throw new IllegalArgumentException(
                    "This student has no active adopter yet. Records are saved under an approved assignment.");
        }
        return active;
    }

    public ArrayList<Support> getSupportRecords() {
        ArrayList<Support> all = new ArrayList<>();
        for (AdoptionAssignment a : assignments) {
            all.addAll(a.getSupports());
        }
        return all;
    }

    public ArrayList<MonitoringActivity> getMonitoringActivities() {
        ArrayList<MonitoringActivity> all = new ArrayList<>();
        for (AdoptionAssignment a : assignments) {
            all.addAll(a.getActivities());
        }
        return all;
    }

    public void addProgramParticipation(ProgramParticipation participation) {
        if (!participation.checkEligibility()) {
            throw new IllegalArgumentException("Enroll the participation in a term first.");
        }
        for (ProgramParticipation p : participations) {
            if (p.checkEligibility()
                    && p.getSemester().equals(participation.getSemester())
                    && p.getAcademicYear().equals(participation.getAcademicYear())) {
                throw new IllegalArgumentException("Student is already enrolled for that term.");
            }
        }
        participations.add(participation);
    }

    public int getParticipationCount() {
        return participations.size();
    }

    /** Returns the most recent participation record, or null if there is none. */
    public ProgramParticipation getCurrentParticipation() {
        if (participations.isEmpty()) {
            return null;
        }
        return participations.get(participations.size() - 1);
    }
}
