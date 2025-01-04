import java.util.Objects;
/**
 * Represents a book in the library, including its details and borrowing status.
 */
public class Book {
    // Attributes
    /**
     * The title of the book.
     */
    private String title;

    /**
     * The first author of the book.
     */
    private String author1;

    /**
     * The second author of the book (if any).
     */
    private String author2;

    /**
     * The publisher of the book.
     */
    private String publisher;

    /**
     * The year the book was published.
     */
    private int yearPublication;

    /**
     * The International Standard Book Number (ISBN) of the book.
     */
    private String isbn;

    /**
     * The accession number of the book.
     */
    private long accessionNum;
    /**
     * The next accession number to be assigned to a book.
     */
    private static long nextAccessionNum=1001;
    /**
     * The library member that the book is issued to.
     */
    private LibMember issuedTo;

    // Constructors

    /**
     * Default constructor that initializes the attributes to default values.
     */
    public Book() {
        title = "";
        author1 = "";
        author2 = "";
        publisher = "";
        yearPublication = 0;
        isbn = "";
        accessionNum=nextAccessionNum++;
        issuedTo = null;
    }
    /**
     * Parameterized constructor to initialize the attributes with data.
     *
     * @param title           the title of the book.
     * @param author1         the first author of the book.
     * @param author2         the second author of the book.
     * @param publisher       the publisher of the book.
     * @param yearPublication the year of publication.
     * @param isbn            the ISBN of the book.
     */
    public Book(String title, String author1, String author2, String publisher, int yearPublication, String isbn) {
        this.isbn = isbn;
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        this.accessionNum=nextAccessionNum++;
    }
// Getters & Setters

    /**
     * Gets the title of the book.
     *
     * @return the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the first author of the book.
     *
     * @return the first author of the book.
     */
    public String getAuthor1() {
        return author1;
    }

    /**
     * Sets the first author of the book.
     *
     * @param author1 the new first author of the book.
     */
    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    /**
     * Gets the second author of the book.
     *
     * @return the second author of the book.
     */
    public String getAuthor2() {
        return author2;
    }

    /**
     * Sets the second author of the book.
     *
     * @param author2 the new second author of the book.
     */
    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    /**
     * Gets the publisher of the book.
     *
     * @return the publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book.
     *
     * @param publisher the new publisher of the book.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the year of publication of the book.
     *
     * @return the year of publication.
     */
    public int getYearPublication() {
        return yearPublication;
    }

    /**
     * Sets the year of publication of the book.
     *
     * @param yearPublication the new year of publication.
     */
    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the new ISBN of the book.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * Gets the accession number of the book.
     *
     * @return the accession number.
     */
    public long getAccessionNum() {
        return accessionNum;
    }
    /**
     * Sets the accession number of the book.
     *
     * @param accessionNum the new accession number of the book.
     */
    public void setAccessionNum(long accessionNum) {
        this.accessionNum = accessionNum;
    }
    /**
     * Gets the library member the book is issued to.
     *
     * @return the library member who has the book issued, or null if the book is not issued.
     */
    public LibMember getIssuedTo() {
        return issuedTo;
    }
    /**
     * Sets the library member the book is issued to.
     *
     * @param issuedTo the library member the book is issued to.
     */
    public void setIssuedTo(LibMember issuedTo) {
        this.issuedTo = issuedTo;
    }
    /**
     * Returns a string representation of the book's attributes.
     *
     * @return a string representation of the book's attributes.
     */
    @Override
    public String toString() { // slightly adjusted for better readability.
        return "Book: [" +
                  title + " " +
                 author1 + " " +
                 author2 + " " +
                publisher + " " +
                yearPublication +
                isbn + " " +
                accessionNum +
                issuedTo +
                ']';
    }

    /**
     * Compares this book to another object to check if they are equal.
     *
     * @param o the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return yearPublication == book.yearPublication && accessionNum == book.accessionNum && Objects.equals(title, book.title) && Objects.equals(author1, book.author1) && Objects.equals(author2, book.author2) && Objects.equals(publisher, book.publisher) && Objects.equals(isbn, book.isbn) && Objects.equals(issuedTo, book.issuedTo);
    }
}
