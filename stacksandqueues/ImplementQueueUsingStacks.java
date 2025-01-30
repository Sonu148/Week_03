package day_02.stacksandqueues;
import java.util.*;
import java.util.Stack;

public class ImplementQueueUsingStacks {
    // creating queue class.
    public static  class Queue {

        // creating the two empty stack.
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // method for the adding the element in the stack1.
        void addingElement(int num) {
            stack1.push(num);
        }

        // Method for removing the element and performing the operation.
        void removingElement() {
            if (stack2.isEmpty()) {// checking the stack2 is empty or not
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if(stack2.isEmpty()) {
                System.out.println("The queue is empty ");
            }
            else{
                System.out.print(stack2.pop()+" ");
            }
      }
    }

    // main method for the running the program
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Queue queue= new Queue();// creating the Queue object of queue class.

        // taking the user input as size of the stack.
        System.out.print("enter the size of the stack :");
        int k = input.nextInt();

        // taking the elements of the stack.
        System.out.println("enter the number :");
        for(int i=0; i<k; i++) {
            int num = input.nextInt();
            queue.addingElement(num);
        }
        // printing the result.
        System.out.print("The queue element: ");
        for (int i = 0; i <k ; i++) {
            queue.removingElement();
        }
    }
}
