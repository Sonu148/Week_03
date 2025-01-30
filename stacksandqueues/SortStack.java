package day_02.stacksandqueues;
import java.util.Stack;

public class SortStack {
    // creating the two empty stack.
    Stack <Integer> stack1= new Stack<>();
    Stack <Integer> stack2= new Stack<>();

    // method to add the element in the stack1.
    void addElement(int n){
        stack1.push(n);
    }
    // Method for adding the element in the sorting the stack element in ascending order.
    void operation(){
      while(!stack1.isEmpty()){
          int temp=stack1.pop(); // storing the stack1 element in temp.

          while(!stack2.isEmpty()&& stack2.peek()>temp){
              stack1.push(stack2.pop());
          }
          stack2.push(temp);// push the temp into the stack2
        }
      // display the stack2 element.
        System.out.println("The sorted stack: "+stack2);

    }
   // main method for the running the program
    public static void main(String[] args) {
         SortStack stack= new SortStack();
        int[] arr= {2,4,4,8,7,1,8,2};
        for (int n: arr){
            stack.addElement(n);
        }
        stack.operation();

    }
}
