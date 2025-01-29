package day_01.circularlinkedlist.onlineticketreservationsystem;
class TicketReservationSystem {
    // Inner class for representing each ticket (node)
    private class TicketNode {
        int ticketID;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        // Constructor
        public TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketID = ticketID;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head = null;
    private TicketNode tail = null;
    private int ticketCount = 0;

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        ticketCount++;
    }

    // Remove a ticket by Ticket ID
    public boolean removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return false;
        }

        TicketNode current = head;
        TicketNode previous = null;

        // Case 1: The ticket to be removed is the head
        if (head.ticketID == ticketID) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            ticketCount--;
            return true;
        }

        // Case 2: Traverse the list to find the ticket
        do {
            previous = current;
            current = current.next;
            if (current.ticketID == ticketID) {
                previous.next = current.next;
                if (current == tail) {
                    // If removed node was the tail
                    tail = previous;
                }
                ticketCount--;
                return true;
            }
        // Loop until we come back to the head
        } while (current != head);

        System.out.println("Ticket with ID " + ticketID + " not found.");
        return false;
    }

    // Display all the tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        // Circular list, so stop when we loop back to the head
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTickets(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.contains(searchTerm) || current.movieName.contains(searchTerm)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found matching the search term.");
        }
    }

    // Calculate the total number of booked tickets
    public int totalTickets() {
        return ticketCount;
    }
}