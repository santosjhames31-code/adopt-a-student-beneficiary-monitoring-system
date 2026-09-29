package OOP_Group1;
public class Person{
    
    //PARENT CLASS
    
    private String id, name, contactNumber;
    
    Person(String id, String name, String contactNumber){
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
}