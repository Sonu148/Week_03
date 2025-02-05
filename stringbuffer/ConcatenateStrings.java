package day_04.stringbuffer;

public class ConcatenateStrings {
    // method for the concatenate the strings
    public static String concatenateStrings(String [] str){
        // create a new string buffer
        StringBuffer string = new StringBuffer();
        for (String s : str) {
            // append the string into the string buffer
            string.append(s);
        }
        return string.toString();
    }
    public static void main(String[] args) {
        // taking input as string array.
        String [] str = {"apple", "banana", "Lemon"};
        // calling the method
        String st = concatenateStrings(str);
        System.out.println(st);
    }
}
