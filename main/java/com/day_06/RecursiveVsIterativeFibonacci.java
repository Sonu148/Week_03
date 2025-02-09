package com.day_06;
public class RecursiveVsIterativeFibonacci {

    // Recursive Fibonacci (Exponential Time)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time)
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        // Fibonacci value
        int n = 30;

        // Test recursive Fibonacci
        long startTime = System.nanoTime();
        System.out.println("Recursive Fibonacci: " + fibonacciRecursive(n));
        long endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci time: " + (endTime - startTime) / 1000000 + " ms");

        // Test iterative Fibonacci
        startTime = System.nanoTime();
        System.out.println("Iterative Fibonacci: " + fibonacciIterative(n));
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
