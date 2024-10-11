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
Functionality: The Main class serves as the entry point of the application. It initializes the LaunchPage, which is the first screen users see when they start the application.

LaunchPage Class
Purpose: This class creates the initial GUI for the application.
Components:
JFrame: The main window where the welcome message and button are displayed.
JButton: A button labeled "Open" that transitions to the main application.
JLabel: Displays the title "InterCell PhoneBook".
Constructor: Sets up button properties, label styles, and frame settings. The button click event is handled to open the main application and close the welcome screen.

MainApp Class
Purpose: This class serves as the main interface for managing contacts.
Components:
JFrame: The main menu window where all contact management options are presented.
JButtons: Buttons for adding, searching, deleting, editing contacts, and showing all contacts.
JLabel: Displays "InterCell" as a title.
Constructor: Initializes ContactManager and sets up GUI elements.
Methods:
initializeComponents(): Configures buttons and labels for interaction.
actionPerformed(): Handles button clicks to invoke respective functionalities like adding or searching contacts.

Contact Class
Purpose: Represents an individual contact with attributes for full name and phone number.
Attributes:
fullName: The name of the contact.
phoneNumber: The contact's phone number.
Methods:
Getters and setters allow access to these attributes, while toString() provides a string representation for easy display.

ContactManager Class
Purpose: Manages a list of contacts with functionalities such as adding, searching, deleting, updating, and sorting contacts.
Attributes:
contacts: An ArrayList storing all contact objects.
Methods:
insertContact(): Adds a new contact to the list.
searchContact(): Searches for a contact using binary search; sorts contacts before searching to ensure efficiency.
deleteContact(): Removes a contact by name after locating it with binary search.
updateContact(): Updates an existing contact's phone number based on their name.
sortContacts(): Sorts contacts using selection sort based on their names.

AddPerson Class
Purpose: Provides a GUI for adding a new contact to the contact manager.
Components:
JTextField: For entering name and phone number inputs.
JButton: For submitting new contact information.
Constructor: Sets up GUI elements and their layout. It also centers this window relative to the main menu.
ActionListener: Handles submission of contact details, ensuring both fields are filled before adding to the manager.

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
