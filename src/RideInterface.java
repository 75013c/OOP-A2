/**
 * Defines the contract for a Ride facility in the theme park.
 * Any class implementing this interface must provide the mechanism
 * for queue management, history logging, and ride operation.
 */
public interface RideInterface {

    /**
     * Adds a Visitor to the waiting list (queue) for the ride.
     * @param visitor The Visitor object to be added.
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Attempts to remove a specific Visitor from the queue.
     * @param visitor The Visitor object to be removed.
     * @return true if the Visitor was successfully removed, false otherwise (e.g., if not found).
     */
    boolean removeVisitorFromQueue(Visitor visitor);

    /**
     * Prints the current list of Visitors waiting in the queue.
     */
    void printQueue();

    /**
     * Adds a Visitor to the historical record of those who have taken the ride.
     * @param visitor The Visitor object to be recorded.
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a specific Visitor is present in the ride history.
     * @param visitor The Visitor object to check for.
     * @return true if the Visitor is found in the history, false otherwise.
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Retrieves the total number of Visitors currently in the ride history (or queue,
     * depending on the specific implementation, typically history in this context).
     * @return The count of visitors.
     */
    int numberOfVisitors();

    /**
     * Prints the historical record of all Visitors who have completed the ride.
     */
    void printRideHistory();

    /**
     * Executes one full cycle of the ride operation.
     */
    void runOneCycle();
}