/**
 * Represents an Employee or Staff member within the theme park system.
 * This class extends the abstract Person class, inheriting common attributes
 * and adding specific properties related to employment status.
 */
public class Employee extends Person {

    // Employee-specific instance variables
    private String employeeId;
    private String role;
    private boolean isWorking;

    /**
     * Default constructor for the Employee class.
     * Calls the default constructor of the superclass (Person) and initializes
     * employee-specific fields with default values.
     */
    public Employee() {
        super();
        this.employeeId = "E000";
        this.role = "Unassigned";
        this.isWorking = false;
    }

    /**
     * Parameterized constructor for the Employee class.
     * @param name The name of the employee (from Person).
     * @param age The age of the employee (from Person).
     * @param phoneNumber The phone number (from Person).
     * @param employeeId The unique employee ID.
     * @param role The job role.
     * @param isWorking The current working status.
     */
    public Employee(String name, int age, String phoneNumber, String employeeId, String role, boolean isWorking) {
        super(name, age, phoneNumber);
        this.employeeId = employeeId;
        this.role = role;
        this.isWorking = isWorking;
    }

    // Getter Methods
    public String getEmployeeId() {
        return employeeId;
    }

    public String getRole() {
        return role;
    }

    public boolean isWorking() {
        return isWorking;
    }

    // Setter Methods
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}