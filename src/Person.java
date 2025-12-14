/**
 * The abstract base class representing any person within the theme park system.
 * It establishes common properties and methods shared by both Staff/Employees and Visitors.
 */
public abstract class Person {

    // Instance variables (fields) are private to enforce encapsulation.
    private String name;
    private int age;
    private String phoneNumber;

    /**
     * Default constructor for the Person class.
     * Initializes fields with default/placeholder values.
     */
    public Person() {
        this.name = "Unknown";
        this.age = -1;
        this.phoneNumber = "N/A";
    }

    /**
     * Parameterized constructor for the Person class.
     * * @param name The name of the person.
     * @param age The age of the person.
     * @param phoneNumber The phone number of the person.
     */
    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}