import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class Main{
    public static void main(String[]args){
        LaunchPage launchPage = new LaunchPage();
    }
}


class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton myButton = new JButton("Open");
    JLabel Text = new JLabel("InterCell PhoneBook", JLabel.CENTER);

    LaunchPage() {

        myButton.setBounds(100, 160, 200, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        myButton.setBackground(Color.white);
        myButton.setBorder(BorderFactory.createEtchedBorder());

        Text.setForeground(Color.white);
        Text.setFont(new Font("Roboto", Font.BOLD, 36));
        Text.setBounds(-182, 100, 800, 50);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 206, 141));
        frame.setVisible(true);
        frame.add(myButton);
        frame.add(Text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton) {
            new MainApp();
            frame.dispose();

        }
    }

}



class MainApp implements ActionListener {
    private JFrame mainMenu;
    private JButton addPersonButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton showAllButton;
    private JButton editButton;
    private JLabel textLabel;

    private ContactManager contactManager;

    public MainApp() {
        contactManager = new ContactManager(); // Initialize ContactManager

        // Initialize JFrame
        mainMenu = new JFrame("CapitalEstate");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(740, 480);
        mainMenu.setResizable(false);
        mainMenu.getContentPane().setBackground(new Color(255, 206, 141));
        mainMenu.setLayout(null);

        // Initialize and configure buttons and label
        initializeComponents();

        // Set JFrame visible
        mainMenu.setVisible(true);
    }

    private void initializeComponents() {
        // Add Person Button
        addPersonButton = new JButton("+");
        addPersonButton.setBounds(40, 240, 40, 40);
        addPersonButton.setFocusable(false);
        addPersonButton.addActionListener(this);
        addPersonButton.setBackground(Color.WHITE);
        addPersonButton.setBorder(BorderFactory.createEtchedBorder());
        mainMenu.add(addPersonButton);

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(140, 240, 100, 40);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchButton.setBackground(Color.WHITE);
        searchButton.setBorder(BorderFactory.createEtchedBorder());
        mainMenu.add(searchButton);

        // Delete Button
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(290, 240, 100, 40);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setBorder(BorderFactory.createEtchedBorder());
        mainMenu.add(deleteButton);

        // Edit Button
        editButton = new JButton("Edit");
        editButton.setBounds(440, 240, 100, 40);
        editButton.setFocusable(false);
        editButton.addActionListener(this);
        editButton.setBackground(Color.WHITE);
        editButton.setBorder(BorderFactory.createEtchedBorder());
        mainMenu.add(editButton);

        // Show All Button
        showAllButton = new JButton("Show All");
        showAllButton.setBounds(590, 240, 100, 40);
        showAllButton.setFocusable(false);
        showAllButton.addActionListener(this);
        showAllButton.setBackground(Color.WHITE);
        showAllButton.setBorder(BorderFactory.createEtchedBorder());
        mainMenu.add(showAllButton);

        // Text Label
        textLabel = new JLabel("InterCell");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Roboto", Font.BOLD, 48));
        textLabel.setBounds(250, 100, 800, 50);
        mainMenu.add(textLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addPersonButton) {
            addPerson();
        } else if (source == searchButton) {
            searchContact();
        } else if (source == deleteButton) {
            deleteContact();
        } else if (source == editButton) {
            editContact();
        } else if (source == showAllButton) {
            showAllContacts();
        }
    }

    // Add Person Functionality
    private void addPerson() {
        new AddPerson(contactManager); // Pass the ContactManager instance
    }

    // Search Contact Functionality using Binary Search
    private void searchContact() {
        String fullName = JOptionPane.showInputDialog(mainMenu, "Enter Full Name to Search:", "Search Contact", JOptionPane.PLAIN_MESSAGE);
        if (fullName != null && !fullName.trim().isEmpty()) {
            Contact contact = contactManager.searchContact(fullName.trim());
            if (contact != null) {
                JOptionPane.showMessageDialog(mainMenu, contact.toString(), "Contact Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainMenu, "Contact Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Delete Contact Functionality
    private void deleteContact() {
        String fullName = JOptionPane.showInputDialog(mainMenu, "Enter Full Name to Delete:", "Delete Contact", JOptionPane.PLAIN_MESSAGE);
        if (fullName != null && !fullName.trim().isEmpty()) {
            boolean success = contactManager.deleteContact(fullName.trim());
            if (success) {
                JOptionPane.showMessageDialog(mainMenu, "Contact Deleted Successfully!");
            } else {
                JOptionPane.showMessageDialog(mainMenu, "Contact Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Edit Contact Functionality
    private void editContact() {
        String fullName = JOptionPane.showInputDialog(mainMenu, "Enter Full Name to Edit:", "Edit Contact", JOptionPane.PLAIN_MESSAGE);
        if (fullName != null && !fullName.trim().isEmpty()) {
            Contact contact = contactManager.searchContact(fullName.trim());
            if (contact != null) {
                String newPhone = JOptionPane.showInputDialog(mainMenu, "Enter New Phone Number:", contact.getPhoneNumber());
                if (newPhone != null && !newPhone.trim().isEmpty()) {
                    contactManager.updateContact(fullName.trim(), newPhone.trim());
                    JOptionPane.showMessageDialog(mainMenu, "Contact Updated Successfully!");
                } else {
                    JOptionPane.showMessageDialog(mainMenu, "Phone number cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mainMenu, "Contact Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Show All Contacts Functionality using Selection Sort
    private void showAllContacts() {
        contactManager.sortContacts(); // Sort contacts using selection sort
        ArrayList<Contact> allContacts = contactManager.getAllContacts();
        if (allContacts.isEmpty()) {
            JOptionPane.showMessageDialog(mainMenu, "No Contacts Available.");
        } else {
            // Create a new JFrame to display all contacts
            JFrame contactFrame = new JFrame("All Contacts");
            contactFrame.setSize(500, 500);
            contactFrame.setLayout(new BorderLayout());

            JTextArea contactArea = new JTextArea();
            contactArea.setEditable(false);

            StringBuilder sb = new StringBuilder();
            for (Contact contact : allContacts) {
                sb.append(contact.toString()).append("\n");
            }
            contactArea.setText(sb.toString());

            JScrollPane scrollPane = new JScrollPane(contactArea);
            contactFrame.add(scrollPane, BorderLayout.CENTER);

            contactFrame.setVisible(true);
        }
    }

    // Contact class
    class Contact {
        private String fullName;
        private String phoneNumber;

        public Contact(String fullName, String phoneNumber) {
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
        }

        // Getters and Setters
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        // toString method for easy display
        @Override
        public String toString() {
            return "Name: " + fullName + ", Phone: " + phoneNumber;
        }
    }

    // ContactManager class
    class ContactManager {
        private ArrayList<Contact> contacts;

        // Comparator for binary search
        private Comparator<Contact> byFullName = new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getFullName().compareToIgnoreCase(c2.getFullName());
            }
        };

        public ContactManager() {
            contacts = new ArrayList<>();
        }

        // Insert Contact
        public void insertContact(String fullName, String phoneNumber) {
            contacts.add(new Contact(fullName, phoneNumber));
        }

        // Search Contact by Full Name using Binary Search
        public Contact searchContact(String fullName) {
            sortContacts();
            Contact keyContact = new Contact(fullName, "");
            int index = binarySearch(contacts, keyContact, byFullName);
            if (index >= 0) {
                return contacts.get(index);
            }
            return null;
        }

        private int binarySearch(ArrayList<Contact> list, Contact key, Comparator<Contact> comparator) {
            int low = 0;
            int high = list.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                Contact midVal = list.get(mid);
                int cmp = comparator.compare(midVal, key);

                if (cmp < 0)
                    low = mid + 1;
                else if (cmp > 0)
                    high = mid - 1;
                else
                    return mid;
            }
            return -1;
        }

        // Display All Contacts
        public ArrayList<Contact> getAllContacts() {
            return contacts;
        }

        // Delete Contact by Full Name
        public boolean deleteContact(String fullName) {
            sortContacts();
            Contact keyContact = new Contact(fullName, "");
            int index = binarySearch(contacts, keyContact, byFullName);
            if (index >= 0) {
                contacts.remove(index);
                return true;
            }
            return false;
        }

        // Update Contact's Phone Number using Full Name as a search parameter
        public boolean updateContact(String fullName, String newPhoneNumber) {
            Contact contact = searchContact(fullName);
            if (contact != null) {
                contact.setPhoneNumber(newPhoneNumber);
                return true;
            }
            return false;
        }

        // Sort Contacts by Full Name using Selection Sort
        public void sortContacts() {
            int n = contacts.size();
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (byFullName.compare(contacts.get(j), contacts.get(minIdx)) < 0) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    Contact temp = contacts.get(i);
                    contacts.set(i, contacts.get(minIdx));
                    contacts.set(minIdx, temp);
                }
            }
        }
    }

    // AddPerson class
    class AddPerson extends JFrame implements ActionListener {
        private JTextField nameField;
        private JTextField phoneField;
        private JButton submitButton;
        private ContactManager contactManager;

        public AddPerson(ContactManager contactManager) {
            this.contactManager = contactManager;
            setTitle("Add New Contact");
            setSize(300, 200);
            setLocationRelativeTo(mainMenu); // Center relative to main menu
            setLayout(new GridLayout(3, 2, 10, 10));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Initialize components
            JLabel nameLabel = new JLabel("Full Name:");
            nameField = new JTextField();
            JLabel phoneLabel = new JLabel("Phone Number +264 83:");
            phoneField = new JTextField();
            submitButton = new JButton("Submit");

            // Add action listener
            submitButton.addActionListener(this);

            // Add components to frame
            add(nameLabel);
            add(nameField);
            add(phoneLabel);
            add(phoneField);
            add(new JLabel()); // Empty cell
            add(submitButton);

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String fullName = nameField.getText().trim();
            String phoneNumber = phoneField.getText().trim();

            if (!fullName.isEmpty() && !phoneNumber.isEmpty()) {
                contactManager.insertContact(fullName, phoneNumber);
                JOptionPane.showMessageDialog(this, "Contact Added Successfully!");
                dispose(); // Close the AddPerson window
            } else {
                JOptionPane.showMessageDialog(this, "Please enter both name and phone number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp());
    }
}



