import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringConcatenationTest {

    @Test
    public void testStringConcatenation() {
        int n = 10000;  // Number of strings to concatenate
        String str = "Hello";
        String[] strings = new String[n];

        // Initialize the strings array
        for (int i = 0; i < n; i++) {
            strings[i] = " World";
        }

        // Measure time for String concatenation
        long startTime = System.nanoTime();
        String resultString = str;
        for (String s : strings) {
            resultString += s;
        }
        long endTime = System.nanoTime();
        long stringConcatenationTime = (endTime - startTime) / 1000000;  // Convert to milliseconds

        System.out.println("String concatenation time: " + stringConcatenationTime + " ms");
        Assertions.assertTrue(stringConcatenationTime > 0, "String concatenation should take some time");

        // Measure time for StringBuilder concatenation
        startTime = System.nanoTime();
        StringBuilder resultStringBuilder = new StringBuilder(str);
        for (String s : strings) {
            resultStringBuilder.append(s);
        }
        endTime = System.nanoTime();
        long stringBuilderConcatenationTime = (endTime - startTime) / 1000000;  // Convert to milliseconds

        System.out.println("StringBuilder concatenation time: " + stringBuilderConcatenationTime + " ms");
        Assertions.assertTrue(stringBuilderConcatenationTime > 0, "StringBuilder concatenation should take some time");

        // Measure time for StringBuffer concatenation
        startTime = System.nanoTime();
        StringBuffer resultStringBuffer = new StringBuffer(str);
        for (String s : strings) {
            resultStringBuffer.append(s);
        }
        endTime = System.nanoTime();
        long stringBufferConcatenationTime = (endTime - startTime) / 1000000;  // Convert to milliseconds

        System.out.println("StringBuffer concatenation time: " + stringBufferConcatenationTime + " ms");
        Assertions.assertTrue(stringBufferConcatenationTime > 0, "StringBuffer concatenation should take some time");

        // Assert that StringBuilder and StringBuffer are faster than String
        Assertions.assertTrue(stringBuilderConcatenationTime < stringConcatenationTime, "StringBuilder should be faster than String");
        Assertions.assertTrue(stringBufferConcatenationTime < stringConcatenationTime, "StringBuffer should be faster than String");
    }
}
