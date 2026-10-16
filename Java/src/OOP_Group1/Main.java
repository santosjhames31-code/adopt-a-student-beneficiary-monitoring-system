package OOP_Group1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        
        // Benificiary Class
            //add
            //edit 
            //del
            //check status
        Date date = new Date();
        StudentBeneficiary sb = new StudentBeneficiary("2025007491", "Jhames Andrew Santos", "639307850603", "2nd Year", "BSIT", "Santa Maria", "Active");
        sb.displayInfo();

        FacultyAdopter adopter = new FacultyAdopter("ADOPT-123", "Jeff Bezos", "09123232", "Management");
        sb.viewAdopter(adopter);
        
        Coordinator coordinator = new Coordinator("COOR-123", "Sir shun", "BSIT");

        AdoptionAssignment as = new AdoptionAssignment(adopter.getId(), sb.getId(), " ");
        as.activate(date);
        System.out.println("Assignment ID :  " + as.getAssignmentId());
    }   
}
    