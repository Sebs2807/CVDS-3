package edu.eci.cvds.tdd.library.exceptions;

public class LibraryException extends Exception {
    public static final String USER_NOT_FOUND = "User not found.";
    public static final String BOOK_NOT_AVAILABLE = "Book is not available.";
    public static final String ACTIVE_LOAN_EXISTS = "There is already an active loan for this book by the user.";
    public static final String LOAN_NOT_FOUND = "The loan doesn't exists in the system.";
    public static final String LOAN_ALREADY_RETURNED = "The loan has already been returned.";
    

    public LibraryException(String message) {
        super(message);
    }
}
