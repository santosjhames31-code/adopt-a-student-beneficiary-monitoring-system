package abstraction;


public class Main {
    public static void main (String[] args){
       
       Car c = new Car("Civic", 3);
       Vehicles v = c; 
    //    Vehicles v = new Car("Cvic", 4);
       v.details();

       Vehicles vehicle = new Vehicles();
        vehicle = (Car) c;

       }

    } 
    

