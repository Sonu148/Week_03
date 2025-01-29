package day_01.singlylinkedlist.socialmediasystem;
import java.util.ArrayList;

public class SocialMedia  {

    // User node representing a person in the system
    class User {
        int userId;               // Unique ID for each user
        String name;              // User's name
        int age;                  // User's age
        FriendList friends;       // List of friends (Friend IDs)
        User next;                // Points to the next user in the list

        // Constructor to create a new user with basic details
        public User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new FriendList();  // Initialize empty friend list
            this.next = null;
        }
    }

    // FriendList class to store a user's friends (can store as a list of friend IDs)
    class FriendList {
        ArrayList<Integer> friendIds;  // List of Friend IDs

        // Constructor to initialize an empty friend list
        public FriendList() {
            this.friendIds = new ArrayList<>();
        }

        // Method to add a friend ID to the list
        public void addFriend(int friendId) {
            if (!friendIds.contains(friendId)) {
                friendIds.add(friendId);
            }
        }

        // Method to remove a friend ID from the list
        public void removeFriend(int friendId) {
            friendIds.remove(Integer.valueOf(friendId));
        }

        // Method to check if a specific friend exists in the list
        public boolean isFriend(int friendId) {
            return friendIds.contains(friendId);
        }

        // Method to get all friend IDs
        public ArrayList<Integer> getFriends() {
            return friendIds;
        }
    }

    private User head;  // Head of the user list
    private int size;   // Number of users in the system

    // Constructor to initialize the empty system
    public SocialMedia() {
        head = null;
        size = 0;
    }

    // Add a new user to the system
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
        size++;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null && user1.userId != user2.userId) {
            user1.friends.addFriend(userId2);
            user2.friends.addFriend(userId1);
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friends.removeFriend(userId2);
            user2.friends.removeFriend(userId1);
        }
    }

    // Find mutual friends between two users
    public ArrayList<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        ArrayList<Integer> mutualFriends = new ArrayList<>();

        if (user1 != null && user2 != null) {
            for (int friendId : user1.friends.getFriends()) {
                if (user2.friends.isFriend(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);

        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int friendId : user.friends.getFriends()) {
                System.out.println("User ID: " + friendId);
            }
        }
    }

    // Search for a user by User ID
    public User findUserById(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null; // Return null if user is not found
    }

    // Search for a user by Name
    public User findUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null; // Return null if user is not found
    }

    // Count the number of friends for a user
    public int countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.friends.getFriends().size();
        }
        return 0; // Return 0 if user is not found
    }

    // Display all users and their friends
    public void displayAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
            displayFriends(current.userId);
            current = current.next;
        }
    }


}
