package day_04.stringbuilder;
import java.util.HashSet;

public class RemoveDuplicate {

    // Method for the removing the duplicates.
    public static String removeDuplicates(String str){
        // Creating the new string builder.
    StringBuilder string = new StringBuilder();
    // Create the hashset for storing the character.
    HashSet<Character> ch= new HashSet<>();

    // Looping the string
        for(int i=0; i<str.length(); i++){
            char character=str.charAt(i);
            // checking if the character is in the hashset or not.
            if(!ch.contains(character)){
                string.append(character);// append the character
                ch.add(character);
            }
        }
      return string.toString();// returning the string.
    }

    public static void main(String[] args) {
        // taking the input as string
        String str="APPLEAP";

        // calling the method.
        String removeDuplicatesString= removeDuplicates(str);
        //display the result.
        System.out.println("The duplicate removed string is : "+ removeDuplicatesString);
    }
}
