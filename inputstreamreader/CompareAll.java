package day_04.inputstreamreader;
import java.io.*;

public class CompareAll {
    public static void main(String[] args) {
         String str = "hello";
        int iterations = 1_000_000;

        // Measure time for StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " ms");

        // Measure time for StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " ms");

        //  Read a large file and count words
        // Ensure you have a 100MB file named large_file.txt in the same directory
        String filePath = "src/sample.txt";
        countWordsInFile(filePath);
    }

    private static void countWordsInFile(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words based on whitespace
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total words in file: " + wordCount);
        System.out.println("Time taken to read file: " + (endTime - startTime) + " ms");
    }
}