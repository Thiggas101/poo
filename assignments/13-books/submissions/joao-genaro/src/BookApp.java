public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("Programação Genérica", 2020, "João Silva");

        PrintBook printedBook = new PrintBook("Java Avançado", 2018, "Maria Souza", "TechEditora", "978-85-333-1234-5");

        AudioBook audioBook = new AudioBook("Aprendendo Java", 2021, "Carlos Lima", 150.5, 120, "Ana Paula");

        System.out.println(genericBook.toString());
        System.out.println(printedBook.toString());
        System.out.println(audioBook.toString());
    }
}