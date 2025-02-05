package day_04.stringbuilder;

 public class ReverseString {

     // Methods for the reverse the string .
    public static String reverse(String str) {

    //  Create a new string builder.
    StringBuilder string = new StringBuilder();
        for (int i = 0; i<str.length(); i++) {
            // append each of char into the string builder.
            string.append(str.charAt(i));
        }
        //returning the string in reverse order using build in method.
        return string.reverse().toString();
    }

    // Main method  for run the program.
    public static void main(String[] args) {
        // taking the string.
        String str = "apple";

        // Method calling
        String newString= reverse(str);

        System.out.println(newString);
    }
}