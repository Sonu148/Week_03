package com.day_06;
public class StringConcatenation {

    public static void main(String[] args) {
        // Number of strings to concatenate
        int n = 10000;
        String str = "Hello";
        String[] strings = new String[n];

        // Initialize the strings array
        for (int i = 0; i < n; i++) {
            strings[i] = " World";
        }

        // Performance test for String
        long startTime = System.nanoTime();
        String resultString = str;
        for (String s : strings) {
            resultString += s;
        }
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) / 1000000 + " ms");

        // Performance test for StringBuilder
        startTime = System.nanoTime();
        StringBuilder resultStringBuilder = new StringBuilder(str);
        for (String s : strings) {
            resultStringBuilder.append(s);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) / 1000000 + " ms");

        // Performance test for StringBuffer
        startTime = System.nanoTime();
        StringBuffer resultStringBuffer = new StringBuffer(str);
        for (String s : strings) {
            resultStringBuffer.append(s);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
