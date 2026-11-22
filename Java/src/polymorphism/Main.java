package polymorphism;
import java.util.ArrayList;
public class Main {
    
    public static void main (String[] args){
        
        // ArrayList<City> c = new ArrayList<>();

        // c.add(new SantaMaria());
        // c.add(new Marilao());
        // c.add(new Malolos());

        // for(City city : c){
        //     city.cityName();
        //     city.population();
        //     System.out.println("");
        // }    

        City c = new City();
        
        if(c instanceof SantaMaria s){
            s.cityName();
        }

    }
    
}
