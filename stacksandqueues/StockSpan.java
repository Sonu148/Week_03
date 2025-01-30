package day_02.stacksandqueues;

import java.util.Stack;

public class StockSpan {
    public static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while they are smaller than current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means current price is the highest so far
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Push current index onto stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateStockSpan(prices);

        // Print result
        System.out.print("Stock Span: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
