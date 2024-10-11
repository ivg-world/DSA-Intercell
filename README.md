# Intercelll

Overview

This Java application serves as a simple phone book, allowing users to add, search, edit, and delete contacts. It utilizes Swing for the graphical user interface (GUI) and implements basic functionalities for managing contact information.

Features

Add Contacts: Users can add new contacts with a full name and phone number.
Search Contacts: Users can search for contacts by name.
Edit Contacts: Users can update existing contact information.
Delete Contacts: Users can remove contacts from the phone book.
Display All Contacts: Users can view all saved contacts in a separate window.

Requirements

Java Development Kit (JDK) 8 or higher
IDE (e.g., IntelliJ IDEA, Eclipse) or command line for running Java applications

File Structure

The project consists of several Java classes:

Main: Entry point of the application.
LaunchPage: Initial GUI that launches the main application.
MainApp: Main interface for managing contacts.
ContactManager: Handles storage and operations on contacts.
Contact: Represents a single contact with a name and phone number.
AddPerson: GUI for adding new contacts.

Installation

Clone or download the repository containing the Java files.
Open the project in your preferred IDE or set up a Java environment in your terminal.

Compile the Java files:
bash
javac Main.java LaunchPage.java MainApp.java ContactManager.java Contact.java AddPerson.java

Run the application:
bash
java Main

Usage Instructions

Launch the Application: Upon starting, you will see a welcome screen with an "Open" button.
Main Menu: After clicking "Open," the main menu will appear with options to add, search, edit, delete, or show all contacts.
Adding a Contact: Click the "+" button to open a form where you can enter the contact's name and phone number.
Searching for a Contact: Click "Search" and enter the full name of the contact you wish to find.
Editing a Contact: Click "Edit" to modify an existing contact's phone number.
Deleting a Contact: Click "Delete" to remove a contact by entering their full name.
Displaying All Contacts: Click "Show All" to view all saved contacts in a new window.

Code Explanation

Main Class
The Main class initializes the application by creating an instance of LaunchPage.

LaunchPage Class
This class sets up the initial GUI with a button to open the main application.

MainApp Class
This class manages all functionalities related to contact management, including adding, searching, editing, and deleting contacts.

ContactManager Class
Handles operations on an ArrayList of Contact objects, including searching using binary search and sorting using selection sort.

Contact Class
Represents individual contacts with attributes for full name and phone number.

AddPerson Class
Provides a GUI for users to input new contact details.

Conclusion

This Java PhoneBook application is designed for ease of use and provides essential functionalities for managing personal contacts effectively. By following this README, users should be able to set up and operate the application without difficulty.



# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*
replay_pid*
