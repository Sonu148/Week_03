package day_04.inputstreamreader;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Specify the file name where the input will be written
        String fileName = "src/sample.txt";

        // Create InputStreamReader and BufferedReader to read from console
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(fileName, true)) {

            String userInput;

            System.out.println("Enter your input (type 'exit' to quit):");

            // Read user input in a loop
            while (true) {
                userInput = bufferedReader.readLine(); // Read a line of input

                // Check if the user wants to exit
                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Exit the loop
                }

                // Write the input to the file
                fileWriter.write(userInput + System.lineSeparator());
            }

            System.out.println("Input has been written to " + fileName);

        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
}
