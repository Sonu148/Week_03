package day_01.circularlinkedlist.taskscheduler;
public class TaskScheduler {

    // Node representing a task in the scheduler
    class TaskNode {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        // Points to the next task in the circular list
        TaskNode next;

        public TaskNode(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private TaskNode head;
    private TaskNode tail;
    private int size;

    // Constructor to initialize an empty task scheduler
    public TaskScheduler() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            // Update the last task's next to point to the head
            tail.next = head;
        }
        size++;
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
        size++;
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            // Update tail if added at the end
            tail = newTask;
        }
        size++;
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        if (head.taskId == taskId) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                // Update the circular link
                tail.next = head;
            }
            size--;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Task not found.");
            return;
        }

        if (temp.next == tail) {
            // Update tail if task to remove is the last one
            tail = temp;
        }
        // Bypass the task to be removed
        temp.next = temp.next.next;
        size--;
    }

    // View the current task and move to the next task
    public void viewNextTask() {
        if (head != null) {
            System.out.println("Current Task: " + head.taskName + ", Due: " + head.dueDate);
            // Move to the next task
            head = head.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks in the list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        // Continue until we reach back to the head
        } while (temp != head);
    }

    // Search for a task by priority
    public void searchByPriority(int priority) {
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + " (Task ID: " + temp.taskId + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Get the number of tasks
    public int getSize() {
        return size;
    }
}