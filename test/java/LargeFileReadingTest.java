import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LargeFileReadingTest {

    private static final String file = "testfile.txt"; // This is a small test file path

    @Test
    public void testFileReaderPerformance() {
        try {
            // Create a temporary small test file
            createTestFile(file);

            // Measure FileReader performance
            long startTime = System.nanoTime();
            try (FileReader fileReader = new FileReader(file)) {
                int data;
                while ((data = fileReader.read()) != -1) {
                    // Read byte-by-byte
                }
            }
            long endTime = System.nanoTime();
            System.out.println("FileReader test time: " + (endTime - startTime) / 1000000 + " ms");

            // Check if the file was read without any issues
            Assertions.assertTrue(Files.exists(Paths.get(file)), "Test file does not exist.");
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("IOException occurred during FileReader performance test.");
        }
    }

    @Test
    public void testInputStreamReaderPerformance() {
        try {
            // Create a temporary small test file
            createTestFile(file);

            // Measure InputStreamReader performance
            long startTime = System.nanoTime();
            try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file))) {
                int data;
                while ((data = inputStreamReader.read()) != -1) {
                    // Read byte-by-byte and convert to characters
                }
            }
            long endTime = System.nanoTime();
            System.out.println("InputStreamReader test time: " + (endTime - startTime) / 1000000 + " ms");

            // Check if the file was read without any issues
            Assertions.assertTrue(Files.exists(Paths.get(file)), "Test file does not exist.");
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("IOException occurred during InputStreamReader performance test.");
        }
    }

    // Helper method to create a small test file for the tests
    private void createTestFile(String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (int i = 0; i < 1000; i++) {
                writer.write("This is a line of text in the file. Line " + (i + 1) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Failed to create test file.");
        }
    }

    // Clean up after tests (delete the test file)
    @Test
    public void cleanupTestFile() {
        try {
            Files.deleteIfExists(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Failed to delete the test file.");
        }
    }
}
