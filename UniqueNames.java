import java.util.HashSet;

public class UniqueNames {
    public static void main(String[] args) {
        // Array with duplicate names
        String[] names = {"Ritika", "Malvika", "Nidhi", "Neeraj", "Ritika"};

        // Storing names in HashSet to eliminate duplicates
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }

        // Checking if a specific name exists
        String searchName = "Ritika";
        if (uniqueNames.contains(searchName)) {
            System.out.println(searchName + " exists in the set.");
        } else {
            System.out.println(searchName + " does not exist in the set.");
        }

        // Printing unique names
        System.out.println("Unique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
