package abstraction;

public class Boat extends Vehicles {
    
    Boat(String vehicleType, int numberOfWheels){
        this.vehicleType = vehicleType;
        this.numberOfWheels = numberOfWheels;
    }

    @Override 
    void details(){
        System.out.println("Boat");
        System.out.println("Vehicle Type  : " + vehicleType);
        System.out.println("Wheels        : " + numberOfWheels);
    }

}
