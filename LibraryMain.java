import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        LibrarySystem myLibrary = new LibrarySystem();
        Scanner kbd = new Scanner(System.in);
       int choice;
        do {
            System.out.println("\n=== Library System Menu ===");
            System.out.println("1. Add a new book");
            System.out.println("2. Delete a book");
            System.out.println("3. Add a new member");
            System.out.println("4. Delete a member");
            System.out.println("5. Issue a book");
            System.out.println("6. Return a book");
            System.out.println("7. Search for a book");
            System.out.println("8. Search for a member");
            System.out.println("9. Display books issued to a member");
            System.out.println("10. Check if a book is issued");
            System.out.println("11. Display library data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = kbd.nextInt();

            switch (choice) {
                case 1: {
                    // Add a new book
                    kbd.nextLine();
                    System.out.print("Enter book title: ");
                    String title = kbd.nextLine();

                    System.out.print("Enter first author: ");
                    String author1 =kbd.nextLine();

                    System.out.print("Enter second author (enter null if none): ");
                    String author2 = kbd.nextLine();

                    System.out.print("Enter publisher: ");
                    String publisher = kbd.nextLine();

                    System.out.print("Enter year of publication: ");
                    int year = kbd.nextInt();
                    kbd.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = kbd.nextLine();
                    if(isbn.length() != 13) {
                        System.out.println("ISBN has to be 13 digits!");
                        break;
                    }


                    Book book = new Book(title, author1, author2, publisher, year, isbn);
                    if (myLibrary.addBook(book)) {
                        System.out.println("Book added successfully! The accession number "+book.getAccessionNum()+" has been assigned!");
                    } else {
                        System.out.println("Book already exists in the library.");
                    }
                    break;
                }
                case 2 : {
                    // Delete a book
                    System.out.print("Enter the accession number of the book to delete: ");
                    long accessionNum = kbd.nextLong();
                    if (myLibrary.deleteBook(accessionNum)) {
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("Unable to delete the book.");
                    }
                    break;
                }
                case 3 : {
                    // Add a new member
                    System.out.print("Enter member first name: ");
                    String firstName = kbd.next();
                    System.out.print("Enter member last name: ");
                    String lastName = kbd.next();
                    System.out.print("Enter gender (M/F): ");
                    char gender = kbd.next().charAt(0);
                    System.out.print("Enter CPR number: ");
                    long cpr = kbd.nextLong();
                    System.out.print("Enter telephone number: ");
                    String teleNum = kbd.next();

                    LibMember member = new LibMember(firstName, lastName, gender, cpr, teleNum);
                    if (myLibrary.addMember(member)) {
                        System.out.println("Member added successfully!");
                    } else {
                        System.out.println("Member already exists in the library. Check the CPR number.");
                    }
                    break;
                }
                case 4 : {
                    // Delete a member
                    System.out.print("Enter the CPR number of the member to delete: ");
                    long cpr = kbd.nextLong();
                    if (myLibrary.deleteMember(cpr)) {
                        System.out.println("Member deleted successfully!");
                    } else {
                        System.out.println("Unable to delete the member.");
                    }
                    break;

                }
                case 5 : {
                    // Issue a book
                    System.out.print("Enter book accession number: ");
                    long accessionNum = kbd.nextLong();
                    System.out.print("Enter member CPR number: ");
                    long cpr = kbd.nextLong();
                    if (myLibrary.issueBook(accessionNum, cpr)) {
                        System.out.println("Book issued successfully!");
                    } else {
                        System.out.println("Unable to issue the book.");
                    }
                    break;
                }
                case 6 : {
                    // Return a book
                    System.out.print("Enter the accession number of the book to return: ");
                    long accessionNum = kbd.nextLong();
                    if (myLibrary.returnBook(accessionNum)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Unable to return the book.");
                    }
                    break;
                }
                case 7 : {
                    // Search for a book
                    System.out.print("Enter book accession number: ");
                    long accessionNum = kbd.nextLong();
                    int bookIndex = myLibrary.searchBook(accessionNum);
                    if (bookIndex != -1) {
                        System.out.println("Book found at index: " + bookIndex);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
                case 8 : {
                    // Search for a member
                    System.out.print("Enter member's CPR number: ");
                    long cpr = kbd.nextLong();
                    int memberIndex = myLibrary.searchMember(cpr);
                    if (memberIndex != -1) {
                        System.out.println("Member found at index: " + memberIndex);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                }
                case 9 : {
                    // Display books issued to a member
                    System.out.print("Enter member CPR number: ");
                    long cpr = kbd.nextLong();
                    myLibrary.printBooksIssued(cpr);
                    break;
                }
                case 10 : {
                    // Check if a book is issued
                    System.out.print("Enter book accession number: ");
                    long accessionNum = kbd.nextLong();
                    if (myLibrary.isBookIssued(accessionNum)) {
                        System.out.println("The book is issued.");
                    } else {
                        System.out.println("The book is not issued.");
                    }
                    break;
                }
                case 11 : {
                    // Displays the library's data
                    System.out.println("Number of books in the library: " + myLibrary.sizeBooksList());
                    System.out.println("Number of members in the library: " + myLibrary.sizeMembersList());
                    break;
                }
                case 0 :
                    System.out.println("Exiting the Library System.");
                    break;
                default :
                    System.out.println("Invalid choice. Please try again.");

            }
        } while (choice != 0);


  }
}