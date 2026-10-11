package lt.techin.oop;
public class Book {
    private String name;
    private int publicationYear;
    public Book(String name, int publicationYear) { this.name = name; this.publicationYear = publicationYear; }
    public String getName() { return name; }
    public int getPublicationYear() { return publicationYear; }
    @Override public boolean equals(Object other) { // TODO compare both fields
        if (this == other) {
            return true;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        Book book = (Book) other;
        return publicationYear == book.publicationYear
                && java.util.Objects.equals(name, book.name);
    }
    @Override public int hashCode() { // TODO use the same fields as equals
        return java.util.Objects.hash(name, publicationYear);
    }
}