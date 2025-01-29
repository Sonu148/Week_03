package day_01.singlylinkedlist.socialmediasystem;

public class Main {
    // Main method to test the system
    public static void main(String[] args) {
        SocialMedia system = new SocialMedia ();

        // Adding users
        system.addUser(1, "sohan", 25);
        system.addUser(2, "saytam", 30);
        system.addUser(3, "ankit", 22);

        // Adding friends
        system.addFriendConnection(1, 2);
        system.addFriendConnection(1, 3);

        // Displaying friends of Alice
        system.displayFriends(1);

        // Displaying all users and their friends
        system.displayAllUsers();

        // Removing a friend connection
        system.removeFriendConnection(1, 2);

        // Displaying friends of Alice after removing Bob
        system.displayFriends(1);

        // Finding mutual friends between Alice and Charlie
        System.out.println("Mutual Friends between Alice and Charlie: " + system.findMutualFriends(1, 3));

        // Counting the number of friends for Alice
        System.out.println("Number of friends for Alice: " + system.countFriends(1));
    }
}
