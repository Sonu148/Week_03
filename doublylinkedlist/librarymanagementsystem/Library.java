package day_01.doublylinkedlist.librarymanagementsystem;
public class Library {

    // Node (Book) class representing a book in the library
    class Book {
        String title;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        Book next;
        Book prev;

        public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    private Book head;
    private Book tail;
    // Number of books in the library
    private int size;

    // Constructor to initialize an empty library
    public Library() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);

        if (head == null) {
            // If library is empty, set both head and tail to the new book
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        size++;
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);

        // If library is empty, set both head and tail to the new book
        if (tail == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        size++;
    }

    // Add a new book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index.");
            return;
        }

        if (index == 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        if (index == size) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;
        size++;
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                     tail = current.prev;
                }

                size--;
                System.out.println("Book with ID " + bookId + " has been removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Title
    public Book searchBookByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return current;
            }
            current = current.next;
        }
        // Return null if book is not found
        return null;
    }

    // Search for a book by Author
    public Book searchBookByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                return current;
            }
            current = current.next;
        }
        // Return null if book is not found
        return null;
    }

    // Update the Availability status of a book by Book ID
    public void updateBookAvailability(int bookId, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability of book with ID " + bookId + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookId + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookId + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return size;
    }

}
