/**
 * This class is designed for managing a library system.
 * It manages basic library actions, like adding, removing, managing books/members.
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class LibrarySystem {
    // Attributes
    /**
     * List of books in the library.
     */
    private final LinkedList<Book> booksList;

    /**
     * List of library members.
     */
    private final LinkedList<LibMember> membersList;

    /**
     * Number of books in the library.
     */
    private int booksListSize;

    /**
     * Number of members in the library.
     */
    private int membersListSize;

    /**
     * Default constructor to initialize the attributes.
     */
    public LibrarySystem() {
        booksList = new LinkedList<>();
        membersList = new LinkedList<>();
        booksListSize = 0;
        membersListSize = 0;
    }

    /**
     * Adds a book to the library.
     *
     * @param obj the book object to add.
     * @return true if the book was added, false if it already exists.
     */
    public boolean addBook(Book obj) {
        if (booksList.contains(obj)) {
            return false;
        }
        booksList.addLast(obj);
        booksListSize++;
        return true;
    }

    /**
     * Removes a book from the library.
     *
     * @param accessionNum the accession number of the book.
     * @return true if the book was deleted, false if it's issued to a member or not found.
     */
    public boolean deleteBook(long accessionNum) {
        ListIterator<Book> iter = booksList.listIterator();
        while (iter.hasNext()) {
            Book bookInfo = iter.next();
            if (bookInfo.getAccessionNum() == accessionNum) {
                if (bookInfo.getIssuedTo() != null) {
                    return false;
                }
                iter.remove();
                booksListSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a member to the library.
     *
     * @param obj the member object to add.
     * @return true if the member was added, false if they already exist.
     */
    public boolean addMember(LibMember obj) {
        for (LibMember member : membersList) {
            if (member.getCprNumber() == obj.getCprNumber()) {
                return false;
            }
        }
        membersList.add(obj);
        membersListSize++;

        return true;
    }

    /**
     * Removes a member from the library.
     *
     * @param cpr the CPR number of the member.
     * @return true if the member was removed, false if they have books issued or if they don't exist.
     */
    public boolean deleteMember(long cpr) {
        ListIterator<LibMember> iter = membersList.listIterator();
        while (iter.hasNext()) {
            LibMember member = iter.next();
            if (member.getCprNumber() == cpr) {
                if (member.getNumBooksIssued() != 0) {
                    return false;
                }
                iter.remove();
                membersListSize--;
                return true;
            }
        }

        return false;
    }

    /**
     * Searches for a book in the library by accession number.
     *
     * @param accessionNum the accession number of the book.
     * @return the index of the book, or -1 if not found.
     */
    public int searchBook(long accessionNum) {
        ListIterator<Book> iter = booksList.listIterator();
        while (iter.hasNext()) {
            Book bookInfo = iter.next();
            if (bookInfo.getAccessionNum() == accessionNum) {
                System.out.println(bookInfo.getTitle());
                return iter.previousIndex();
            }
        }
        return -1;
    }

    /**
     * Searches for a member in the library by CPR number.
     *
     * @param cprNum the CPR number of the member.
     * @return the index of the member, -1 if not found.
     */
    public int searchMember(long cprNum) {
        ListIterator<LibMember> iter = membersList.listIterator();
        while (iter.hasNext()) {
            LibMember member = iter.next();
            if (member.getCprNumber() == cprNum) {
                System.out.println(member.getFirstName()+" "+member.getLastName());
                return iter.previousIndex();
            }
        }
        return -1;
    }

    /**
     * Checks if the books list is empty.
     *
     * @return true if the books list is empty, false otherwise.
     */
    public boolean isEmptyBooksList() {
        return booksList.isEmpty();
    }

    /**
     * Checks if the members list is empty.
     *
     * @return true if the members list is empty, false otherwise.
     */
    public boolean isEmptyMembersList() {
        return membersList.isEmpty();
    }

    /**
     * Gets the number of books in the library.
     *
     * @return the size of the books list.
     */
    public int sizeBooksList() {
        return booksListSize;
    }

    /**
     * Gets the number of members in the library.
     *
     * @return the size of the members list.
     */
    public int sizeMembersList() {
        return membersListSize;
    }

    /**
     * Issues a book to a library member.
     *
     * @param accessionNum the accession number of the book.
     * @param cprNum       the CPR number of the member.
     * @return true if the book was issued successfully, false otherwise.
     */
    public boolean issueBook(long accessionNum, long cprNum) {
        int bookIndex = searchBook(accessionNum);
        int memberIndex = searchMember(cprNum);
        if (bookIndex == -1 || memberIndex == -1) {
            return false;
        }
        Book book = booksList.get(bookIndex);
        LibMember member = membersList.get(memberIndex);
        if (book.getIssuedTo() != null || member.getNumBooksIssued() == 10) {
            return false;
        }

        book.setIssuedTo(member);
        while (member.getBooksIssued().size() <= member.getNumBooksIssued()) {
            member.getBooksIssued().add(null);
        }
        member.getBooksIssued().set(member.getNumBooksIssued(), book);
        member.setNumBooksIssued(member.getNumBooksIssued() + 1);
        return true;
    }

    /**
     * Returns a book to the library.
     *
     * @param accessionNum the accession number of the book.
     * @return true if the book was returned successfully, false otherwise.
     */
    public boolean returnBook(long accessionNum) {
        int bookIndex = searchBook(accessionNum);
        if (bookIndex == -1) {
            return false;
        }
        Book book = booksList.get(bookIndex);
        if (book.getIssuedTo() == null) {
            return false;
        }

        LibMember member = book.getIssuedTo();
        if (member.getBooksIssued().contains(book)) {
            member.getBooksIssued().remove(book);
        }
        book.setIssuedTo(null);
        member.setNumBooksIssued(member.getNumBooksIssued()-1);
        return true;
    }

    /**
     * Prints the list of books issued to a library member.
     *
     * @param cprNum the CPR number of the member.
     */
    public void printBooksIssued(long cprNum) {
        if (searchMember(cprNum) != -1) {
            LibMember libMember = membersList.get(searchMember(cprNum));

            for (Book book : libMember.getBooksIssued()) {
                if (book != null)
                    System.out.println(book.toString());

            }
        }
    }

    /**
     * Checks if a book is issued.
     *
     * @param accessionNum the accession number of the book.
     * @return true if the book is issued, false otherwise.
     */
    public boolean isBookIssued(long accessionNum) {
        int bookIndex = searchBook(accessionNum);
        if (bookIndex == -1) {
            return false;
        }
        Book book = booksList.get(bookIndex);
        return book.getIssuedTo() != null;
    }
}