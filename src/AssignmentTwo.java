/**
 * Main class for demonstrating the functionality of the  Park Rides Visitor Management System.
 */
public class AssignmentTwo {

    /**
     * The entry point of the application. Executes all demonstration parts sequentially.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }


    public void partThree() {
        System.out.println("Part 3 Demonstration");

        // Create an Employee and a Ride object.
        Employee op01 = new Employee("Alice", 28, "1567738", "E001", "Operator", true);
        Ride spaceShuttle = new Ride("Space Shuttle", 15, op01, 120);

        // Create 5 Visitors object.
        Visitor v01 = new Visitor("Henry", 22, "1896547", "V001", 167, true);
        Visitor v02 = new Visitor("Arthur", 30, "1789045", "V002", 173,false);
        Visitor v03 = new Visitor("Omar", 18, "1890435", "V003", 182,false);
        Visitor v04 = new Visitor("Ford", 25, "1367834", "V004", 160,false);
        Visitor v05 = new Visitor("Hank", 40, "1570935", "V005", 154,true);

        // Add visitors to the queue.
        System.out.println("\nAdd 5 visitor to the Queue.");
        spaceShuttle.addVisitorToQueue(v01);
        spaceShuttle.addVisitorToQueue(v02);
        spaceShuttle.addVisitorToQueue(v03);
        spaceShuttle.addVisitorToQueue(v04);
        spaceShuttle.addVisitorToQueue(v05);

        // Remove a visitor.
        System.out.println("\nRemove a visitor from the Queue.");
        spaceShuttle.removeVisitorFromQueue(v03);

        // Print visitor information in the queue.
        System.out.println("\nPrint all visitors in the Queue.");
        spaceShuttle.printQueue();
    }


    public void partFourA() {
        System.out.println("Part 4A Demonstration");

        // Create an Employee and a Ride object.
        Employee op02 = new Employee("Bob", 37, "1678907", "E002", "Operator", true);
        Ride pirateShip = new Ride("Pirate Ship", 30, op02, 120);

        // Create 5 Visitors object.
        Visitor v06 = new Visitor("Edward", 18, "1658943", "V006", 177, true);
        Visitor v07 = new Visitor("Noah", 21, "1678900", "V007", 158, false);
        Visitor v08 = new Visitor("Chloe", 16, "1456678", "V008", 168, true);
        Visitor v09 = new Visitor("Lucas", 35, "1560098", "V009", 172, false);
        Visitor v10 = new Visitor("Penny", 29, "1560987", "V010", 166, true);
        Visitor v11 = new Visitor("Nikki", 23, "1569987", "V011", 170, false);

        // Add visitors to ride history.
        System.out.println("\nAdd 5 visitors to ride history.");
        pirateShip.addVisitorToHistory(v06);
        pirateShip.addVisitorToHistory(v07);
        pirateShip.addVisitorToHistory(v08);
        pirateShip.addVisitorToHistory(v09);
        pirateShip.addVisitorToHistory(v10);

        // Check for presence of visitors.
        System.out.println("\nCheck if a visitor is in the history.");
        pirateShip.checkVisitorFromHistory(v07);
        pirateShip.checkVisitorFromHistory(v11);

        // Print visitor numbers in history.
        System.out.println("\nPrint the number of visitors in the history.");
        pirateShip.numberOfVisitors();
        System.out.println("The ride History of " + pirateShip.getRideName() + " contains " + pirateShip.numberOfVisitors() + " visitors.");

        // Print visitor information in ride history.
        System.out.println("\nPrint all visitors in the history.");
        pirateShip.printRideHistory();
    }


    public void partFourB() {
        System.out.println("Part 4B Demonstration");

        // Create an Employee and a Ride object.
        Employee op03 = new Employee("Moon", 22, "1673455", "E003", "Manager", true);
        Ride rollerCoaster = new Ride("Roller Coaster", 100, op03, 130);

        // Create 5 Visitors object.
        Visitor v12 = new Visitor("Jorge", 26, "1451129", "V012", 173, true);
        Visitor v13 = new Visitor("Elon", 30, "1784450", "V013", 165, false);
        Visitor v14 = new Visitor("King", 18, "1340095", "V014", 180, false);
        Visitor v15 = new Visitor("Brown", 22, "1589934", "V015", 175, true);
        Visitor v16 = new Visitor("Yara", 40, "1879923", "V016", 167, true);

        // Add visitors to ride history.
        System.out.println("\nAdd 5 visitors to ride history.");
        rollerCoaster.addVisitorToHistory(v12);
        rollerCoaster.addVisitorToHistory(v13);
        rollerCoaster.addVisitorToHistory(v14);
        rollerCoaster.addVisitorToHistory(v15);
        rollerCoaster.addVisitorToHistory(v16);

        // Print unsorted history.
        System.out.println("\nPrint all Visitors in the collection.");
        rollerCoaster.printRideHistory();

        // Create the custom comparator.
        VisitorPassAgeComparator passAgeSorter = new VisitorPassAgeComparator();

        // Sort the ride history
        System.out.println("\nSort the collection");
        rollerCoaster.sortRideHistory(passAgeSorter);

        // Print sorted history.
        System.out.println("\nPrint all Visitors in the collection after sorted.");
        rollerCoaster.printRideHistory();
    }


    public void partFive() {
        System.out.println("Part 5 Demonstration");

        // Create an Employee and a Ride object.
        Employee op04 = new Employee("Jane Doe", 32, "1678845", "E004", "Specialist", true);
        Ride dropTower = new Ride("Drop Tower", 7, op04, 140);

        // Create 10 Visitors object.
        Visitor v17 = new Visitor("Dick", 26, "1451129", "V017", 173, true);
        Visitor v18 = new Visitor("Mark", 30, "1784450", "V018", 165, false);
        Visitor v19 = new Visitor("Stan", 18, "1340095", "V019", 180, false);
        Visitor v20 = new Visitor("Bill", 22, "1589934", "V020", 175, true);
        Visitor v21 = new Visitor("Hale", 40, "1879923", "V021", 167, true);
        Visitor v22 = new Visitor("Ian", 26, "1451129", "V022", 173, true);
        Visitor v23 = new Visitor("Tony", 30, "1784450", "V023", 165, false);
        Visitor v24 = new Visitor("Otto", 18, "1340095", "V024", 180, false);
        Visitor v25 = new Visitor("Neil", 22, "1589934", "V025", 175, true);
        Visitor v26 = new Visitor("Leo", 40, "1879923", "V026", 167, true);

        // Add visitors to the queue.
        System.out.println("\nAdd 10 Visitors to the Queue");
        dropTower.addVisitorToQueue(v17);
        dropTower.addVisitorToQueue(v18);
        dropTower.addVisitorToQueue(v19);
        dropTower.addVisitorToQueue(v20);
        dropTower.addVisitorToQueue(v21);
        dropTower.addVisitorToQueue(v22);
        dropTower.addVisitorToQueue(v23);
        dropTower.addVisitorToQueue(v24);
        dropTower.addVisitorToQueue(v25);
        dropTower.addVisitorToQueue(v26);

        // Print visitor information in the queue.
        System.out.println("\nPrint all visitors in the Queue.");
        dropTower.printQueue();

        // Run one cycle.
        System.out.println("\nRun one cycle.");
        dropTower.runOneCycle();

        // Print visitor information in the queue after one cycle.
        System.out.println("\nPrint all visitors in the Queue after one cycle.");
        dropTower.printQueue();

        // Print visitor information in ride history.
        System.out.println("\nPrint all visitors in ride history.");
        dropTower.printRideHistory();
    }


    public void partSix() {
        System.out.println("Part 6 Demonstration");

        // Create an Employee and a Ride object.
        Employee op05 = new Employee("Tina", 28, "1789956", "E005", "Attendant", true);
        Ride jungleSafari = new Ride("Jungle Safari", 8, op05, 110);

        // Create 5 Visitors object.
        Visitor v27 = new Visitor("Mike", 19, "1678890", "V027", 150, false);
        Visitor v28 = new Visitor("Sean", 45, "1269984", "V028", 185, true);
        Visitor v29 = new Visitor("Anna", 25, "1689943", "V029", 170, true);
        Visitor v30 = new Visitor("Peter", 18, "1348879", "V030", 145, false);
        Visitor v31 = new Visitor("Lucy", 32, "1340249", "V031", 168, false);

        // Add visitors to ride history.
        System.out.println("\nAdd 5 visitors to ride history.");
        jungleSafari.addVisitorToHistory(v27);
        jungleSafari.addVisitorToHistory(v28);
        jungleSafari.addVisitorToHistory(v29);
        jungleSafari.addVisitorToHistory(v30);
        jungleSafari.addVisitorToHistory(v31);

        // Export ride history to a csv file.
        System.out.println("\nExport the visitors to csv file");
        jungleSafari.exportRideHistory();
    }


    public void partSeven() {
        System.out.println("Part 7 Demonstration");

        // Create an Employee and a Ride object.
        Employee op06 = new Employee("David", 40, "1456677", "E006", "Manager", true);
        Ride ferrisWheel = new Ride("Ferris Wheel", 10, op06, 130);

        // Define the target filename for import.
        String fileName = "Jungle_Safari_ride_history.csv";

        // Import the csv file.
        System.out.println("\nImport the file created in Part 6.");
        ferrisWheel.importRideHistory(fileName);

        // Verify the number of imported visitors.
        System.out.println("\nPrint the number of Visitors in ride history.");
        ferrisWheel.printHistoryCount();

        // Print the information of the imported visitors.
        System.out.println("\nPrint visitor details");
        ferrisWheel.printRideHistory();
    }
}