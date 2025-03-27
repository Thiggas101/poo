public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("Introdução à Programação", 2015, "Carlos Silva");
        PrintBook printedBook = new PrintBook("Java: How to Program", 2017, "Paul Deitel", "Pearson", "978-0-13-474335-6");
        AudioBook audioBook = new AudioBook("Clean Code", 2008, "Robert C. Martin", 250.5, 720, "John Doe");

        System.out.println("=== Livro Genérico ===");
        System.out.println(genericBook + "\n");

        System.out.println("=== Livro Impresso ===");
        System.out.println(printedBook + "\n");

        System.out.println("=== Audiolivro ===");
        System.out.println(audioBook);
    }
}
