import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public void setUp() {

        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetAllBooks() {

        Book book1 = new Book("1", "Book 1", "Author 1");
        Book book2 = new Book("2", "Book 2", "Author 2");
        List<Book> books = Arrays.asList(book1, book2);


        when(bookRepository.getAllBooks()).thenReturn(books);


        List<Book> result = bookService.getAllBooks();


        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
        assertEquals("Author 2", result.get(1).getAuthor());


        verify(bookRepository, times(1)).getAllBooks();
    }


}
