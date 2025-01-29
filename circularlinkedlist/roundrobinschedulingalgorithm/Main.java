package day_01.circularlinkedlist.roundrobinschedulingalgorithm;
public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Initial Process List:");
        scheduler.displayProcesses();

        int timeQuantum = 3;
        scheduler.roundRobinScheduling(timeQuantum);
    }
}