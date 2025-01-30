package day_02.hashmapsandhashfunctions;
import java.util.LinkedList;

public class CustomHashMap<K,V> {


        // Define the size of the hash map (number of buckets)
        private static final int SIZE = 10;
        // Array of LinkedLists to store key-value pairs
        private LinkedList<Entry<K, V>>[] map;

        // Constructor: Initializes the map with a fixed size and empty linked lists
        public CustomHashMap() {
            // Initialize the array of LinkedLists
            map = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                map[i] = new LinkedList<>();
            }
        }

        // Puts a key-value pair into the hash map
        public void put(K key, V value) {
            int index = key.hashCode() % SIZE;

            // Check if the key already exists in the linked list
            for (Entry<K, V> entry : map[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }

            map[index].add(new Entry<>(key, value));
        }

         public V get(K key) {
            // Compute the index using hashCode
            int index = key.hashCode() % SIZE;

            // Search for the key in the corresponding bucket (linked list)
            for (Entry<K, V> entry : map[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return null;
        }

        // Removes the key-value pair associated with the given key
        public void remove(K key) {
            int index = key.hashCode() % SIZE;

            // Remove the entry that matches the key from the linked list
            map[index].removeIf(entry -> entry.key.equals(key));
        }

        // Entry class to store key-value pairs
        private static class Entry<K, V> {
            K key;
            V value;

            // Constructor for the Entry object
            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // Main method to test the custom hash map
        public static void main(String[] args) {
            CustomHashMap<String, Integer> map = new CustomHashMap<>();

            // Add some key-value pairs to the map
            map.put("A", 1);
            map.put("B", 2);


            System.out.println(map.get("A"));
            map.remove("A");
            System.out.println(map.get("A"));
        }
    }


