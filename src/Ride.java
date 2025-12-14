import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;


/**
 * Implements the RideInterface, managing the operational logic for a single theme park ride.
 * This includes queue management, cycle execution, history logging, sorting, and file I/O.
 */
public class Ride implements RideInterface {

    // Ride Properties
    private String rideName;
    private int maxRider;
    private Employee operator;
    private int minHeightCm;
    private int numOfCycles;
    private Queue<Visitor> visitorQueue;
    private List<Visitor> rideHistory;

    /**
     * Default constructor. Initializes ride with default values.
     */
    public Ride() {
        this.rideName = "Default Ride";
        this.maxRider = 10;
        this.operator = null;
        this.minHeightCm = 0;
        this.numOfCycles = 0;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    /**
     * Parameterized constructor.
     * @param rideName The name of the ride.
     * @param maxRider The maximum capacity per cycle.
     * @param operator The assigned employee operator.
     * @param minHeightCm The minimum height requirement.
     */
    public Ride(String rideName, int maxRider, Employee operator, int minHeightCm) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
        this.minHeightCm = minHeightCm;
        this.numOfCycles = 0;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }


    // Getter Methods
    public String getRideName() {
        return rideName;
    }


    public int getMaxRider() {
        return maxRider;
    }


    public Employee getOperator() {
        return operator;
    }


    public int getMinHeightCm() {
        return minHeightCm;
    }


    public int getNumOfCycles() {
        return numOfCycles;
    }


    public Queue<Visitor> getVisitorQueue() {
        return visitorQueue;
    }


    public List<Visitor> getRideHistory() {
        return rideHistory;
    }


    // Setter Methods
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }


    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }


    public void setOperator(Employee operator) {
        this.operator = operator;
    }


    public void setMinHeightCm(int minHeightCm) {
        this.minHeightCm = minHeightCm;
    }


    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // Interface Implementation Methods

    /**
     * Adds a Visitor to the queue. Prevents adding duplicates.
     * Uses Queue.offer() for safe insertion.
     * @param visitor The Visitor to add.
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (this.visitorQueue.contains(visitor)) {
            System.out.println("FAILURE: " + visitor.getName() + " is already in the queue for " +
                    this.rideName + ". Current queue size: " + visitorQueue.size());
            return;
        }

        this.visitorQueue.offer(visitor);
        System.out.println("SUCCESS: " + visitor.getName() + " joined the queue for " +
                this.rideName + ". Current queue size: " + visitorQueue.size());
    }


    /**
     * Removes a specific Visitor from the queue, regardless of position.
     * @param visitor The Visitor to remove.
     * @return true if the Visitor was found and removed, false otherwise.
     */
    @Override
    public boolean removeVisitorFromQueue(Visitor visitor) {
        // Uses the Queue implementation's remove method which returns boolean
        boolean removed = this.visitorQueue.remove(visitor);
        if (removed) {
            System.out.println("SUCCESS: " + visitor.getName() + " was removed from the queue for " + this.rideName +
                    ". Current queue size: " + visitorQueue.size());
        } else {
            System.out.println("FAILURE: " + visitor.getName() + " was not found in the " + this.rideName + " queue.");
        }
        return removed;
    }


    /**
     * Prints the details of all Visitors currently waiting in the queue.
     */
    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("\nOperation Success\n" + "The Waiting Queue for " + this.rideName + " is empty.");
            return;
        }

        System.out.println("\nOperation Success\n" + "The waiting Queue for " + this.rideName + " (Total " + visitorQueue.size() + " visitors)");
        System.out.println("-".repeat(100));
        int index = 1;
        // Standard enhanced for loop iteration is used for printing the contents of the queue
        for (Visitor visitor : visitorQueue) {
            System.out.println(index++ + ". "
                    + "Name: " + visitor.getName()
                    + "\tAge: " + visitor.getAge()
                    + "\t\tPhoneNumber: " + visitor.getPhoneNumber()
                    + "\tVisitorID: " + visitor.getVisitorId()
                    + "\tHeight: " + visitor.getHeightCm() + " cm"
                    + "\tSeasonPass: "  + (visitor.isHasSeasonPass() ? "Yes" : "No"));
        }
        System.out.println("-".repeat(100));
    }


    /**
     * Adds a Visitor to the ride history (completed riders). Prevents adding duplicates.
     * @param visitor The Visitor to add to history.
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (this.rideHistory.contains(visitor)) {
            System.err.println("FAILURE: " + visitor.getName() + " is already in the ride history of " +
                    this.rideName + ". Total visitor number in ride history: " + this.rideHistory.size());
            return;
        }

        this.rideHistory.add(visitor);
        System.out.println("SUCCESS: " + visitor.getName() + " joined ride history of " +
                this.rideName + ". Total visitor number in ride history: " + this.rideHistory.size());
    }


    /**
     * Checks if a specific Visitor is present in the ride history list.
     * @param visitor The Visitor to check for.
     * @return true if the Visitor is found, false otherwise.
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Uses the List.contains() method, which relies on the Visitor.equals() implementation
        boolean found = this.rideHistory.contains(visitor);
        if (found) {
            System.out.println("SUCCESS: " + visitor.getName() + " is found in the ride history of " + this.rideName + ".");
        } else {
            System.out.println("FAILURE: " + visitor.getName() + " is NOT found in the ride history of " + this.rideName + ".");
        }
        return found;
    }


    /**
     * Retrieves the total count of visitors in the ride history.
     * @return The number of visitors in the history list.
     */
    @Override
    public int numberOfVisitors() {
        // Optimised: Directly returns the size of the history list.
        return this.rideHistory.size();
    }


    /**
     * Prints the details of all Visitors who have completed the ride (the history list).
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("\nOperation Success\n" + "The Ride History of " + rideName + " is empty.");
            return;
        }

        System.out.println("\nOperation Success\n" + "The ride History of " + rideName + " (Total " + rideHistory.size() + " visitors)");
        System.out.println("-".repeat(100));
        // Uses an explicit Iterator, which is good practice for collections like List
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index++ + ". "
                    + "Name: " + visitor.getName()
                    + "\tAge: " + visitor.getAge()
                    + "\t\tPhoneNumber: " + visitor.getPhoneNumber()
                    + "\tVisitorID: " + visitor.getVisitorId()
                    + "\tHeight: " + visitor.getHeightCm() + " cm"
                    + "\tSeasonPass: "  + (visitor.isHasSeasonPass() ? "Yes" : "No"));
        }
        System.out.println("-".repeat(100));
    }


    /**
     * Sorts the ride history list using the provided Comparator.
     * @param comparator The custom Comparator defining the sorting rules.
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (this.rideHistory.isEmpty()) {
            System.err.println("FAILURE: Unable to sort,the ride history is empty.");
            return;
        }

        // Uses the List interface's built-in sort method
        this.rideHistory.sort(comparator);
        System.out.println("SUCCESS: The ride history of " + this.rideName + " is sorted by SeasonPass and age.");
    }


    /**
     * Executes one operational cycle of the ride.
     * This involves checking prerequisites (operator, queue), moving riders
     * from the queue to the history list, and incrementing the cycle counter.
     */
    @Override
    public void runOneCycle() {
        // Validation Check 1: Operator must be assigned.
        if (this.operator == null) {
            System.err.println("FAILURE: Ride cannot be run. No ride operator is assigned.");
            return;
        }

        // Validation Check 2: Operator must be clocked in/working.
        if (!this.operator.isWorking()) {
            System.err.println("FAILURE: Ride cannot be run. Operator " + this.operator.getName() + " is currently NOT working.");
            return;
        }

        // Validation Check 3: Queue must have waiting visitors.
        if (visitorQueue.isEmpty()) {
            System.err.println("FAILURE: The waiting Queue is empty. Cannot start a cycle.");
            return;
        }

        // Determine the actual number of riders: limited by max capacity or queue size.
        int maxCapacityPerCycle = this.maxRider;
        int ridersToTake = Math.min(maxCapacityPerCycle, visitorQueue.size());

        System.out.println("SUCCESS: " + this.rideName + " start one cycle with " + ridersToTake + " visitors.");

        for (int i = 0; i < ridersToTake; i++) {
            Visitor rider = visitorQueue.poll();

            if (rider != null) {
                System.out.println("\nVisitor " + rider.getVisitorId() + " " + rider.getName() + " is riding the " + this.rideName);
                this.addVisitorToHistory(rider);
            }
        }

        this.numOfCycles++;
        System.out.println("\n" + rideName + " completed cycle " + numOfCycles +
                ". Remaining " + visitorQueue.size() + " visitors are in the waiting queue.");
    }


    /**
     * Exports the entire ride history to a CSV file.
     * File name format: [rideName]_ride_history.csv
     */
    public void exportRideHistory() {
        if (this.rideHistory.isEmpty()) {
            System.err.println("EXPORT FAILURE: The ride history of " + this.rideName + " is empty. No need to export.");
            return;
        }

        // Prepare the filename
        String safeRideName = this.rideName.replaceAll(" ", "_");
        String fileName = safeRideName + "_ride_history.csv";

        // Uses try-with-resources to ensure PrintWriter and FileWriter are automatically closed
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            // 1. Write the CSV Header Row
            writer.println("Name,Age,ContactNumber,VisitorId,HasSeasonPass,HeightCm");

            // 2. Write Data Rows
            for (Visitor visitor : this.rideHistory) {
                // Manually constructs the CSV string from Visitor properties
                writer.println(visitor.getName() + "," +
                        visitor.getAge() + "," +
                        visitor.getPhoneNumber() + "," +
                        visitor.getVisitorId() + "," +
                        visitor.isHasSeasonPass() + "," +
                        visitor.getHeightCm());
            }

            System.out.println("EXPORT SUCCESS: " + rideHistory.size() + " ride records of " + this.rideName + " was exported to file " + fileName);
            System.out.println("");

        } catch (IOException e) {
            // Catches general I/O errors
            System.err.println("EXPORT FAILURE: I/O Error occurred while writing file " + fileName);
            System.err.println("Exception Details: " + e.getMessage());
        }
    }


    /**
     * Imports ride history records from a specified CSV file, overwriting the current history.
     * Includes error handling for File Not Found, I/O, and data format/type errors.
     * @param filename The path and name of the CSV file to import.
     */
    public void importRideHistory(String filename) {

        if (filename == null || filename.trim().isEmpty()) {
            System.err.println("IMPORT FAILURE: The file name is invalid.");
            return;
        }

        int visitorsImported = 0;
        int dataLineCount = 0;

        // Reinitializes the ride history list to clear old data
        this.rideHistory = new LinkedList<>();

        // Uses try-with-resources for automatic resource closing
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Skip the header row
            reader.readLine();

            // Process data line by line
            while ((line = reader.readLine()) != null) {
                dataLineCount++;
                String[] data = line.split(",");

                // Data Validation Check: Ensure correct number of columns
                if (data.length != 6) {
                    System.err.println("IMPORT ERROR (Line " + dataLineCount + "): The number of data columns is incorrect.");
                    continue;
                }

                try {
                    // Data Parsing and Conversion
                    String name = data[0];
                    // Uses trim() to remove any surrounding whitespace before parsing
                    int age = Integer.parseInt(data[1].trim());
                    String contactNumber = data[2];
                    String visitorId = data[3];
                    // Boolean.parseBoolean is robust as it returns false for any non-true string
                    boolean hasSeasonPass = Boolean.parseBoolean(data[4].trim());
                    int heightCm = Integer.parseInt(data[5].trim());

                    // Recreates the Visitor object from the imported data
                    Visitor newVisitor = new Visitor(name, age, contactNumber, visitorId, heightCm, hasSeasonPass);

                    this.rideHistory.add(newVisitor);
                    visitorsImported++;

                } catch (NumberFormatException e) {
                    // Handles errors if Age or Height contain non-numeric characters
                    System.err.println("IMPORT ERROR (Line " + dataLineCount + "): Data type conversion failed.");
                }
            }
            System.out.println("IMPORT SUCCESS: Import " + visitorsImported + " ride records from " + filename);

        } catch (FileNotFoundException e) {
            // Handles the case where the specified file does not exist
            System.err.println("IMPORT FAILURE: File not found! Please confirm if the file path and name are correct.");
        } catch (IOException e) {
            // Catches general I/O errors during reading
            System.err.println("EXPORT FAILURE: I/O Error occurred while writing file " + filename);
            System.err.println("Exception Details: " + e.getMessage());
        }
    }


    /**
     * Prints a summary count of the records in the ride history.
     */
    public void printHistoryCount() {
        int count = this.rideHistory.size();
        System.out.println("Ride history of " + this.getRideName() + " has " + count + " records.");
    }
}