package day_01.circularlinkedlist.roundrobinschedulingalgorithm;
class RoundRobinScheduler {
    private class Process {
        int processId;
        int burstTime;
        int remainingTime;
        int priority;
        Process next;

        public Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;

            // Initially, remaining time is equal to burst time
            this.remainingTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private Process head;
    private Process tail;

    public RoundRobinScheduler() {
        head = null;
        tail = null;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            // Point to itself
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            // Maintain circularity
            tail.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) return;

        Process current = head;
        Process previous = tail;

        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    // Update tail's next
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    // Update tail's next
                    tail.next = head;
                } else {
                    // Bypass the current node
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) return;

        Process current = head;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;
        int totalProcesses = getProcessCount();

        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > 0) {
                if (current.remainingTime > timeQuantum) {
                    current.remainingTime -= timeQuantum;
                    System.out.println("Process " + current.processId + " executed for " + timeQuantum + " units.");
                } else {
                    System.out.println("Process " + current.processId + " executed for " + current.remainingTime + " units and completed.");
                    totalWaitingTime += (current.burstTime - current.remainingTime);
                    totalTurnAroundTime += current.burstTime;
                    current.remainingTime = 0;
                    completedProcesses++;
                }
            }
            // Move to the next process
            current = current.next;
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / totalProcesses);
    }

    // Get the count of processes in the circular linked list
    private int getProcessCount() {
        if (head == null) return 0;

        int count = 0;
        Process current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Remaining Time: " + current.remainingTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}