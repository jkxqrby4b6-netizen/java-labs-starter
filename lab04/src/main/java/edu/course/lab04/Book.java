package edu.course.lab04;
import java.util.Objects;
public final class Book {
    private final String isbn;
    private final String title;
    public Book(String isbn, String title) {
        if (isbn == null || isbn.trim().isEmpty()) {
             throw new IllegalArgumentException("ISBN не может быть пустым");
        }
        if (title == null) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.isbn = isbn.trim();
        this.title = title;
    }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(isbn, book.isbn);
    }
     @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

