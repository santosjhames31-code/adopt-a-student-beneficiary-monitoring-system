package abstraction;

public class Motorcycle extends Vehicles{
    
    Motorcycle(String vehicleType, int numberOfWheels){
        this.numberOfWheels = numberOfWheels;
        this.vehicleType = vehicleType;
    }
    
    void details(){
        System.out.println("Motor");
        System.out.println("Vehicle Type  : " + vehicleType);
        System.out.println("Wheels        : " + numberOfWheels);
    }
    
}
