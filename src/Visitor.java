/**
 * Represents a Visitor to the theme park.
 * This class extends the abstract Person class, inheriting common attributes
 * and adding specific properties relevant to a visitor.
 */
public class Visitor extends Person {

    // Visitor-specific instance variables
    private String visitorId;
    private boolean hasSeasonPass;
    private int heightCm;

    /**
     * Default constructor for the Visitor class.
     * Calls the default constructor of the superclass (Person) and initializes
     * visitor-specific fields with default values.
     */
    public Visitor() {
        super();
        this.visitorId = "V000";
        this.heightCm = -1;
        this.hasSeasonPass = false;
    }

    /**
     * Parameterized constructor for the Visitor class.
     * @param name The name of the visitor (from Person).
     * @param age The age of the visitor (from Person).
     * @param phoneNumber The phone number (from Person).
     * @param visitorId The unique visitor ID.
     * @param heightCm The visitor's height in centimeters.
     * @param hasSeasonPass The season pass status.
     */
    public Visitor(String name, int age, String phoneNumber, String visitorId, int heightCm, boolean hasSeasonPass) {
        super(name, age, phoneNumber);
        this.visitorId = visitorId;
        this.heightCm = heightCm;
        this.hasSeasonPass = hasSeasonPass;
    }

    // Getter Methods
    public String getVisitorId() {
        return visitorId;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public boolean isHasSeasonPass() {
        return hasSeasonPass;
    }

    // Setter Methods
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }
}