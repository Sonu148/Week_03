package day_03.sorting;

public class StudentMarks {

    // method for the sorting the marks.
    static void  sortStudentMarks(int [] studentMarks){
        int n= studentMarks.length;
        for (int i = 0; i < n-1; i++) {
            int noSwap=0;// initialise for no swap if sorted array is
            for (int j = 0; j < n-i-1; j++) {
                // checking the condition for Swap
                if (studentMarks[j] > studentMarks[j+1]) {
                    int temp=studentMarks[j+1];
                    studentMarks[j+1]=studentMarks[j];
                    studentMarks[j]=temp;
                    noSwap=1;
                }
            }
            // it means no swap required break loop
            if (noSwap==0){
                break;
            }
        }
    }
    // main method foe running the program
    public static void main(String[] args) {
        int [] studentMarks= {65,45,84,92,34,56};
        // printing the original array
        System.out.print("The original array : ");
        for (int num : studentMarks) {
            System.out.print(num + " ");
        }

        sortStudentMarks(studentMarks);
        // printing the sorted array
        System.out.print("\nThe sorted array is : ");
        for (int num : studentMarks) {
            System.out.print(num + " ");
        }
     }
}
