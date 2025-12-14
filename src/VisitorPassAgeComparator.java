import java.util.Comparator;

/**
 * A custom Comparator designed to sort Visitor objects based on two criteria:
 * 1. Primary Key: Season Pass status (Visitors with a pass are prioritized/sorted first).
 * 2. Secondary Key: Age (If pass status is the same, Visitors are sorted by age, youngest first).
 */
public class VisitorPassAgeComparator implements Comparator<Visitor> {

    /**
     * Compares two Visitor objects to determine their order based on pass status and age.
     * * @param v1 The first Visitor to compare.
     * @param v2 The second Visitor to compare.
     * @return A negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {

        boolean pass1 = v1.isHasSeasonPass();
        boolean pass2 = v2.isHasSeasonPass();


        int passComparison = Boolean.compare(pass2, pass1);

        // If pass statuses are different, return the result immediately.
        if (passComparison != 0) {
            return passComparison;
        }

        // If pass statuses are not different, sorts by age in ascending order.
        int age1 = v1.getAge();
        int age2 = v2.getAge();
        return Integer.compare(age1, age2);

    }
}