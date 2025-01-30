package day_02.stacksandqueues;
import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

   static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0;  // Total surplus petrol
        int currentSurplus = 0;  // Surplus petrol for the current journey
        int startPoint = 0;  // Start index
        Queue<PetrolPump> queue = new LinkedList<>(); // Queue to simulate journey

        for (int i = 0; i < petrol.length; i++) {
            PetrolPump pump = new PetrolPump(petrol[i], distance[i]);
            queue.add(pump); // Enqueue each petrol pump
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If the current surplus is negative, reset the journey
            if (currentSurplus < 0) {
                startPoint = i + 1; // Move to the next pump
                currentSurplus = 0; // Reset current surplus
                queue.clear(); // Clear queue as previous journey failed
            }
        }

        // If total surplus is non-negative, return start point; otherwise, return -1
        return (totalSurplus >= 0) ? startPoint : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4}; // Petrol at each pump
        int[] distance = {6, 5, 3, 5}; // Distance to the next pump

        int startPoint = findStartingPoint(petrol, distance);

        if (startPoint == -1) {
            System.out.println("No valid starting point found.");
        } else {
            System.out.println("The tour can be completed starting from pump " + startPoint);
        }
    }
}
