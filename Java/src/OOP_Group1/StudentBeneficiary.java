package OOP_Group1;

import java.util.ArrayList;

public  class StudentBeneficiary extends Person{
    private String yearLevel;
    private String course;
    private String address;
    private String currentStatus;
    private static ArrayList<StudentBeneficiary> studentList = new ArrayList<>(); //list of student

    StudentBeneficiary(
        String id, 
        String name, 
        String contactNumber, 
        String yearLevel, 
        String course, 
        String address,
        String currentStatus){
        super(id, name, contactNumber);
        this.yearLevel = yearLevel;
        this.course = course;
        this.address = address;
        this.currentStatus = currentStatus;
        studentList.add(this);
    }
    //re assign values
    public void updateProfile(String address, String yearLevel, String course){
        this.address = address; 
        this.yearLevel = yearLevel;
        this.course = course;
    }

    public void updateStatus(String currentStatus){
        this.currentStatus = currentStatus;
    }

    public void viewAdopter(FacultyAdopter adopter){ // used FA class as params to access the obj 
        System.out.println("-------------------------------------------------");
        System.out.println("Adopter: " + adopter.getName());
        System.out.println("Department : " + adopter.getDepartment()); //from FA class
        System.out.println("-------------------------------------------------");
    }

    public void displayInfo(){
        System.out.println("-------------------------------------------------");
        System.out.println("Student Info");
        System.out.println("ID : " + getId());
        System.out.println("Name : " + getName());
        System.out.println("Course : " + course);
        System.out.println("Year Level : " + yearLevel);
        System.out.println("Address : " + address);
        System.out.println("Current Status : " + currentStatus);
        System.out.println("-------------------------------------------------");
    }
}
