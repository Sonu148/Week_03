package day_01.circularlinkedlist.onlineticketreservationsystem;
public class Main {

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add tickets
        system.addTicket(101, "Sohan", "Avatar 2", "A1", "2025-01-29 10:00 AM");
        system.addTicket(102, "Ankit", "The Matrix 4", "B2", "2025-01-29 12:00 PM");
        system.addTicket(103, "Satyam", "Avatar 2", "C3", "2025-01-29 02:00 PM");

        // Display tickets
        System.out.println("All tickets:");
        system.displayTickets();

        // Remove a ticket
        system.removeTicket(102);

        // Display tickets again after removal
        System.out.println("\nTickets after removal:");
        system.displayTickets();

        // Search tickets by customer name or movie name
        System.out.println("\nSearch result for 'Avatar':");
        system.searchTickets("Avatar");

        // Get total number of booked tickets
        System.out.println("\nTotal booked tickets: " + system.totalTickets());
    }
}