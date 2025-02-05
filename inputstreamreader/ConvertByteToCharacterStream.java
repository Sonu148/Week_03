package day_04.inputstreamreader;
import java.io.*;

public class ConvertByteToCharacterStream {
    public static void main(String[] args) {
         String filePath = "src/encoding.txt";

        // Create a FileInputStream to read the binary data
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             // Wrap the FileInputStream in an InputStreamReader to convert to character stream
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             // Use BufferedReader to read the characters
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Print each line of characters
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (UnsupportedEncodingException e) {
            System.out.println("The specified encoding is not supported.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
