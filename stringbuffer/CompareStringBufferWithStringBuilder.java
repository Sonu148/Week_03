package day_04.stringbuffer;

public class CompareStringBufferWithStringBuilder {
    public static void main(String[] args) {

        // Create the string buffer and String builder
        StringBuffer stringBuffer= new StringBuffer();
        StringBuilder stringBuilder= new StringBuilder();
        //Declare the start time and end time.
        long startTime, endTime;

        // for calculate time for string buffer
        startTime= System.nanoTime();
        for(int i=0; i<1000000; i++){
            stringBuffer.append("Hello");
        }
        endTime= System.nanoTime();
        // display the time taken by the string buffer
        System.out.println("The time for string buffer is : "+(endTime-startTime) +" ns");

        // for calculate time for string Builder
        startTime= System.nanoTime();
        for(int i=0; i<1000000; i++){
            stringBuilder.append("Hello");
        }
        endTime= System.nanoTime();
        // display the time taken by the strung builder
        System.out.println("The time for string builder is : "+(endTime-startTime) +" ns");

    }
}
