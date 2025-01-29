package day_01.doublylinkedlist.moviemanagementsystem;

class MovieManagementSystem {
    Movie head;
    Movie tail;

    public MovieManagementSystem() {
        head = null;
        tail = null;
    }

    // Add movie record at the beginning
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie record at the end
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a specific position
    public void addMovieAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        Movie current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position out of bounds. Adding movie at the end.");
            addMovieAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
        }
    }

    // Remove movie by Movie Title
    public void removeMovieByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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
                System.out.println("Movie '" + title + "' removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title '" + title + "' not found.");
    }

    // Search for a movie by Director
    public void searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displayMovieDetails(current);
            }
            current = current.next;
        }
    }

    // Search for a movie by Rating
    public void searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                displayMovieDetails(current);
            }
            current = current.next;
        }
    }

    // Display movie details
    private void displayMovieDetails(Movie movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director
                + ", Year of Release: " + movie.yearOfRelease + ", Rating: " + movie.rating);
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        Movie current = head;
        if (current == null) {
            System.out.println("No movies available.");
            return;
        }
        while (current != null) {
            displayMovieDetails(current);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        Movie current = tail;
        if (current == null) {
            System.out.println("No movies available.");
            return;
        }
        while (current != null) {
            displayMovieDetails(current);
            current = current.prev;
        }
    }

    // Update movie rating by Title
    public void updateMovieRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating for '" + title + "' updated to: " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title '" + title + "' not found.");
    }
}