package day_04.filereader;

import java.io.*;

public class ReadFileLineByLine {
    public static void readFile(String file){

        // Declare the file reader and buffer reader as null
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);// read the file
            bufferedReader = new BufferedReader(fileReader); // read each character of the file.

            String line;// initialise the string line
            // checking the condition using while loop
            while((line= bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
        // handle the exception
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // taking the input
        String file = "src/sample.txt";

        // calling the method
        readFile(file);
    }
}
