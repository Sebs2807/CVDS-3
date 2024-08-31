package edu.eci.cvds.tdd.library;

import java.util.Map;

import edu.eci.cvds.tdd.library.book.Book;
import org.junit.Before;
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

    
}
