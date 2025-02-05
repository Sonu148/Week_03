package day_05.linearsearch;
public class SearchForWord {
    public static void main(String[] args) {
        // input string array
        String[] sentences = {
                "Hello world!",
                "Java programming is fun.",
                "I love coding."
        };
        // string that we have to find
        String wordToFind = "Java";
        // calling method
        String foundSentence = findSentenceContainingWord(sentences, wordToFind);
        System.out.println("Sentence containing the word '" + wordToFind + "': " + foundSentence);
    }

    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                // Return the first sentence containing the word
                return sentence;
            }
        }
        // Return "Not Found" if no sentence contains the word
        return "Not Found";
    }
}