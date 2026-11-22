package OOP_Group1;

/** Abstract parent class of every person in the system. */
public abstract class Person {

    private String id;
    private String name;
    private String contactNumber;

    public Person(String id, String name, String contactNumber) {
        this.id = requireText(id, "ID");
        setName(name);
        setContactNumber(contactNumber);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public final void setName(String name) {
        this.name = requireText(name, "Name");
    }

    public final void setContactNumber(String contactNumber) {
        this.contactNumber = requireText(contactNumber, "Contact number");
    }

    // Each subclass shows its own details (polymorphism)
    public abstract void displayInfo();

    // Shared validation used by the subclasses
    protected static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        return value.trim();
    }
}
