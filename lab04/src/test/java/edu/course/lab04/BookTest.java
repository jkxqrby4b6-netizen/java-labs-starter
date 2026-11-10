package edu.course.lab04;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    @Test
    void bookswithsameIsbnShouldBeEqual() {
        Book book1 = new Book("123", "Мастер и Маргарита");
        Book book2 = new Book("123", "Колобок");
        assertEquals(book1, book2, "Книги с равными isbn должны быть равны");
        assertEquals(book1.hashCode(), book2.hashCode(), "Хешкоды книг должны совпадать");
    }
    @Test
    void bookswithDifferentIsbnShouldNotBeEqual() {
        Book book1 = new Book("123", "Рассказы");
        Book book2 = new Book("321", "Рассказы");
        assertNotEquals(book1, book2, "Книги с разными isbn не должны быть равны");
    }
    @Test
    void shouldFindValueByDifferentBookInstanceWithSameIsbn() {
        Map<Book, String> library = new HashMap<>();
        Book bookNumber1 = new Book("12345", "книга1");
        library.put(bookNumber1, "Полка_1");
        Book bookNumber2 = new Book("12345", "книга2");
        String shelf = library.get(bookNumber2);
        assertEquals("Полка_1", shelf, "Должно быть найдено значение по другой книге с тем же isbn");
    }

}
