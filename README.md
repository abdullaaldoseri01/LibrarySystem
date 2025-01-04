Library Management System

Description

This is a Library Management System implemented in Java as part of a university software engineering project. The system provides functionalities to manage books and library members, including adding, removing, issuing, and returning books, as well as managing member details. The project aims to demonstrate practical knowledge in software development and provide a simple solution for library operations.

Features
	•	Add new books to the library.
	•	Remove books from the library.
	•	Add new members to the library.
	•	Remove members from the library.
	•	Issue books to library members.
	•	Return books to the library.
	•	Search for books by their accession number.
	•	Search for members by their CPR number.
	•	Display books currently issued to a member.
	•	Check if a book is issued.
	•	Display the total number of books and members in the library.

Project Structure

The project consists of the following Java files:
	1.	LibrarySystem.java:
The main class that manages the library’s operations, such as adding/removing books and members, issuing/returning books, and searching for records.
	2.	LibraryMain.java:
Contains the main method and a console-based menu-driven interface for interacting with the library system.
	3.	LibMember.java:
Represents a library member, storing their personal details and the books they have issued.
	4.	Book.java:
Represents a book in the library, including its details (title, authors, ISBN, etc.) and its issuance status.

How to Run
	1.	Clone the repository to your local machine. 
       git clone https://github.com/abdullaaldoseri01/LibrarySystem.git
  2.  Open the project in your preferred IDE/text editor & run the libraryMain file.

  3. Interact with the system using the terminal.
  
Future Enhancements

To further improve the system, the following features can be added:
	•	Integrate a database to persist data:
Store book and member information in a database to ensure data is not lost between application restarts.
	•	Add a graphical user interface (GUI):
Replace the console-based interface with a user-friendly GUI for better usability.
	•	Implement user authentication for different roles:
Add login functionality to differentiate between librarians and regular users, with role-specific permissions.

Requirements
	•	Java Development Kit (JDK) 8 or later.
	•	A Java IDE or text editor to compile and run the code.
  




