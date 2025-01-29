package day_01.doublylinkedlist.librarymanagementsystem;

public class Main {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();

        // Add books to the library
        library.addBookAtBeginning("The Hobbit", "J.R.R. Tolkien", "Fantasy", 101, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 102, false);
        library.addBookAtPosition("To Kill a Mockingbird", "Harper Lee", "Fiction", 103, true, 1);

        // Display all books
        System.out.println("Books in the library (Forward Order):");
        library.displayBooksForward();

        // Search for a book by title
        Library.Book foundBook = library.searchBookByTitle("1984");
        if (foundBook != null) {
            System.out.println("\nFound Book: " + foundBook.title + ", Author: " + foundBook.author);
        } else {
            System.out.println("\nBook not found.");
        }

        // Update availability status
        library.updateBookAvailability(102, true);

        // Display books in reverse order
        System.out.println("\nBooks in the library (Reverse Order):");
        library.displayBooksReverse();

        // Remove a book
        library.removeBookById(101);

        // Display total number of books
        System.out.println("\nTotal Books in the library: " + library.countBooks());
    }
}
