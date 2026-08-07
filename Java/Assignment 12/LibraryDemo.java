import library.Book;

public class LibraryDemo {
    public static void main(String[] args) {

        Book b = new Book(
            1,
            "Java Programming",
            "James Gosling",
            599.50
        );

        b.display();
    }
}
