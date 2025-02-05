package day_04.filereader;

import java.io.*;
import java.util.HashMap;

public class CountOccurenceOfWord {
    public static void countOccurence(String file) {

        // creating the file reader and buffer reader as null.
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        // create the hash map .
        HashMap<String, Integer> hash = new HashMap<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                 // Split by any whitespace
                 String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove punctuation and make lowercase
                    word = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
                        // Only process non-empty words
                    if (word.length() > 0) {
                        if (hash.containsKey(word)) {
                            hash.put(word, hash.get(word) + 1);
                        } else {
                            hash.put(word, 1);
                        }
                    }
                }
            }

            // Print the word counts
            for (String word : hash.keySet()) {
                System.out.println("Word = \"" + word + "\", occurrence = " + hash.get(word));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Close the file resources
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // assign the file path
        String file = "src/sample.txt";
        // calling the method
        countOccurence(file);

    }
}
