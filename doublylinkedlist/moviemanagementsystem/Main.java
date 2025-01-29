package day_01.doublylinkedlist.moviemanagementsystem;

public class Main {

    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        // Add movies
        system.addMovieAtBeginning("Inception", "Karan", 2010, 8.8);
        system.addMovieAtEnd("The Dark Knight", "Rohit", 2008, 9.0);
        system.addMovieAtEnd("Interstellar", "Mohan", 2014, 8.6);
        system.addMovieAtPosition(1, "Venom", "Sohan", 2000, 8.4);

        // Display movies forward
        System.out.println("Movies in Forward Order:");
        system.displayMoviesForward();

        // Display movies reverse
        System.out.println("\nMovies in Reverse Order:");
        system.displayMoviesReverse();

        // Search by director
        System.out.println("\nMovies by Director 'Christopher Nolan':");
        system.searchByDirector("Christopher Nolan");

        // Update rating
        system.updateMovieRating("Inception", 9.2);

        // Remove movie
        system.removeMovieByTitle("Venom");

        // Display movies after removal
        System.out.println("\nMovies after removal:");
        system.displayMoviesForward();
    }
}


