import java.util.*;

class RandomizedSet {

    private Random rand = new Random(); // Random object to generate random indices
    // HashMap to store value-to-index mapping for quick lookups and updates
    private HashMap<Integer, Integer> map;
    // List to store values, allowing random access and efficient swaps during removal
    private List<Integer> list;

    public RandomizedSet() {
        // Initialize the HashMap and List
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /**
     * Inserts a value into the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        // Check if the value already exists in the set using the HashMap
        if (map.containsKey(val)) {
            return false; // If the value exists, do nothing and return false
        }

        // Add the value to the map with its index in the list
        map.put(val, list.size());
        // Add the value to the end of the list
        list.add(val);
        return true; // Successfully inserted
    }
    
    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        // Check if the value exists in the set
        if (!map.containsKey(val)) {
            return false; // If the value does not exist, return false
        }

        // Retrieve the index of the element to be removed from the map
        int indexToDelete = map.get(val);
        // Get the index and value of the last element in the list
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);

        // Update the list and map:
        // Overwrite the element to be removed with the last element
        map.put(lastValue, indexToDelete); // Update the lastValue's index in the map
        list.set(indexToDelete, lastValue); // Replace the value at indexToDelete with the lastValue

        // Remove the last element from both the list and map
        map.remove(val); // Remove the value-to-index mapping for the deleted value
        list.remove(lastIndex); // Remove the last element from the list (now redundant)
        return true; // Successfully removed
    }
    
    /**
     * Returns a random element from the set.
     */
    public int getRandom() {
        // Generate a random index and fetch the corresponding element from the list
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Example usage of RandomizedSet:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
