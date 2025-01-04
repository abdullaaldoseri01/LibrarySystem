import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents a library member, storing their personal details and the books they have issued.
 */
public class LibMember {
    // Attributes
    /**
     * The first name of the library member.
     */
    private String firstName;

    /**
     * The last name of the library member.
     */
    private String lastName;

    /**
     * The gender of the library member.
     */
    private char gender;

    /**
     * The CPR number of the library member.
     */
    private long cprNumber;

    /**
     * The telephone number of the library member.
     */
    private String teleNum;

    /**
     * The list of books issued to the library member.
     */
    private ArrayList<Book> booksIssued;

    /**
     * The number of books currently issued to the library member.
     */
    private int numBooksIssued;

    // Constructors

    /**
     * Default constructor to create a library member with default values.
     */
    public LibMember() {
        this.firstName = "";
        this.lastName = "";
        this.gender = ' ';
        this.cprNumber = 0;
        this.booksIssued = new ArrayList<>(10);
        this.teleNum = "";
        this.numBooksIssued = 0;
    }

    /**
     * Parameterized constructor to create a library member with specified details.
     *
     * @param firstName  the first name of the library member.
     * @param lastName   the last name of the library member.
     * @param gender     the gender of the library member.
     * @param cprNumber  the CPR number of the library member.
     * @param teleNum    the telephone number of the library member.
     */
    public LibMember(String firstName, String lastName, char gender, long cprNumber, String teleNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNumber = cprNumber;
        this.teleNum = teleNum;
        this.booksIssued = new ArrayList<>(10);
        this.numBooksIssued = 0;
    }

    // Getters and Setters

    /**
     * Gets the first name of the library member.
     *
     * @return the first name of the library member.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the library member.
     *
     * @param firstName the new first name of the library member.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the library member.
     *
     * @return the last name of the library member.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the library member.
     *
     * @param lastName the new last name of the library member.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the gender of the library member.
     *
     * @return the gender of the library member.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the library member.
     *
     * @param gender the new gender of the library member.
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Gets the CPR number of the library member.
     *
     * @return the CPR number of the library member.
     */
    public long getCprNumber() {
        return cprNumber;
    }

    /**
     * Sets the CPR number of the library member.
     *
     * @param cprNumber the new CPR number of the library member.
     */
    public void setCprNumber(long cprNumber) {
        this.cprNumber = cprNumber;
    }

    /**
     * Gets the telephone number of the library member.
     *
     * @return the telephone number of the library member.
     */
    public String getTeleNum() {
        return teleNum;
    }

    /**
     * Sets the telephone number of the library member.
     *
     * @param teleNum the new telephone number of the library member.
     */
    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    /**
     * Gets the list of books issued to the library member.
     *
     * @return the list of books issued to the library member.
     */
    public ArrayList<Book> getBooksIssued() {
        return booksIssued;
    }

    /**
     * Sets the list of books issued to the library member.
     *
     * @param booksIssued the new list of books issued to the library member.
     */
    public void setBooksIssued(ArrayList<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    /**
     * Gets the number of books currently issued to the library member.
     *
     * @return the number of books currently issued.
     */
    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    /**
     * Sets the number of books currently issued to the library member.
     *
     * @param numBooksIssued the new number of books issued.
     */
    public void setNumBooksIssued(int numBooksIssued) {
        this.numBooksIssued = numBooksIssued;
    }

    // Overridden methods

    /**
     * Compares this library member to another object to check if equal.
     *
     * @param o the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibMember member)) return false;
        return gender == member.gender && cprNumber == member.cprNumber && numBooksIssued == member.numBooksIssued && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(teleNum, member.teleNum) && Objects.equals(booksIssued, member.booksIssued);
    }



    /**
     * Returns a string representation of the library member.
     *
     * @return a string representation of the library member.
     */
    @Override
    public String toString() { // slightly adjusted for better readability.
        return " Library member: [" +
                 firstName + " " +
                 lastName + " " +
                 gender + " "+
                 cprNumber +" " +
                 teleNum + " " +
                 numBooksIssued +
                ']';
    }
}
