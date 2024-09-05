package edu.eci.cvds.tdd.library;


import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.exceptions.LibraryException;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for Library.
 */
public class LibraryTest {

    @Test
    public void shouldAddNewBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1", "ISBN1");
        assertTrue(library.addBook(book));
        assertEquals(1, (int) library.getBooks().get(book));
    }

    @Test
    public void shouldLoanABook() throws LibraryException {
        Library library = new Library();
        Book book = new Book("title1", "author1", "ISBN1");
        User user = new User();
        user.setId("id1");
        user.setName("name1");
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertNotNull(loan.getLoanDate());
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }

    @Test
    public void shouldReturnLoan() throws LibraryException{
        Library library = new Library();
        Book book = new Book("title1", "author1", "ISBN1");
        User user = new User();
        user.setId("id1");
        user.setName("name1");
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertNotNull(loan.getReturnDate());
        assertEquals(1, (int) library.getBooks().get(book));
    }

    @Test(expected = LibraryException.class)
    public void shouldThrowExceptionWhenReturningNonExistentLoan() throws LibraryException {
        Library library = new Library();
        Loan loan = new Loan();
        library.returnLoan(loan);
    }

    @Test
    public void shouldAddUserSuccessfully() {
        Library library = new Library();
        User user = new User();
        user.setId("id1");
        user.setName("name1");
        boolean result = library.addUser(user);
        assertTrue(result);
        assertTrue(library.getUsers().contains(user));
    }

    @Test(expected = LibraryException.class)
    public void shouldThrowExceptionWhenReturningAlreadyReturnedLoan() throws LibraryException {
        Library library = new Library();
        Book book = new Book("title1", "author1", "ISBN1");
        User user = new User();
        user.setId("id1");
        user.setName("name1");
        library.addBook(book);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        library.returnLoan(loan);
        library.returnLoan(loan);
    }

    @Test(expected = LibraryException.class)
    public void shouldThrowExceptionIfActiveLoanExists() throws LibraryException{
        Library library = new Library();
        Book book = new Book("title1", "author1", "ISBN1");
        User user = new User();
        user.setId("id1");
        user.setName("name1");
        library.addBook(book);
        library.addUser(user);
        library.loanABook(user.getId(), book.getIsbn());
        library.loanABook(user.getId(), book.getIsbn());
    }
}
