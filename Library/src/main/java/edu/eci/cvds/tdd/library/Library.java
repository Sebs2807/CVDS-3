package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        try {
            //Verificamos si el libro está en el hash de libros
            if (books.containsKey(book)) {
                books.put(book, books.get(book) + 1);
            } else {
                books.put(book, 1);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn){ //throws UserNotFoundException, BookNotAvailableException, ActiveLoanExistsException {
        User user = null;
        
        //Verificamos si el usuario existe
        for (User u : users) {
            if (u.getId().equals(userId)) {
                user = u;
                break;
            }
        }
        
        if (user == null) {
            //throw new UserNotFoundException("User not found: " + userId);
        }

        //Verificamos si el usuario ya tiene un préstamo activo del mismo libro
        for (Loan l : loans) {
            if (l.getBook().getIsbn().equals(isbn) && l.getUser().getId().equals(userId) && l.getStatus() == LoanStatus.ACTIVE) {
                //throw new ActiveLoanExistsException("The user already has an active loan for this book.");
            }
        }

        Book loanedBook = null;
        
        //Verificamos si el libro está disponible
        for (Book b : books.keySet()) {
            if (b.getIsbn().equals(isbn)) {
                loanedBook = b;
                break;
            }
        }

        if (loanedBook == null || books.get(loanedBook) == 0) {
            //throw new BookNotAvailableException("Book not available: " + isbn);
        }

        //Creamos y el préstamo
        Loan newLoan = new Loan();
        newLoan.setUser(user);
        newLoan.setBook(loanedBook);
        newLoan.setLoanDate(LocalDateTime.now());
        newLoan.setStatus(LoanStatus.ACTIVE);
        
        // Disminuir la cantidad disponible del libro
        books.put(loanedBook, books.get(loanedBook) - 1);

        loans.add(newLoan);
        return newLoan;
    }


    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        //TODO Implement the login of loan a book to a user based on the UserId and the isbn.
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public Map<Book,Integer> getBooks(){
        return books;
    }
}