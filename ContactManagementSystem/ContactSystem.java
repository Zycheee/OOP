import java.io.*;
import java.util.*;

class ContactSystem {
    public static Scanner scan = new Scanner(System.in);

    public void addContacts() { // Add contacts in the file.
        System.out.print("Enter contact name: ");
        String name = scan.nextLine();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("contacts.txt", true))) {
            writer.write(name);
            writer.newLine();
            System.out.println("Contact added successfully.");
        } catch (IOException e) {System.out.println("Error adding contact. Please try again");}
    }

    public void viewContacts(){ // Views the contacts in the file or reads the file then displayed.
        int data;
        File file = new File("contacts.txt");
        if (file.exists()) {
            try(FileReader br = new FileReader("contacts.txt")) {
                System.out.println();
                System.out.println("----------------");
                while ((data = br.read()) != -1)
                    System.out.print((char) data);
                System.out.println("----------------");
            } catch (IOException e) {System.out.println(e.getMessage());}
        }
    }

    public void updateContacts() { // Finds a specific contact and updates it.
        System.out.print("Enter a contact to update: ");
        String findContact = scan.nextLine();
        System.out.print("Enter the updated name: ");
        String updateContact = scan.nextLine();
        File oldFile = new File("contacts.txt");
        File tempFile = new File("contacts_temp.txt");
        boolean contactFound = false;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(oldFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.trim().equals(findContact.trim())) {
                    writer.write(updateContact + System.lineSeparator());  // Write the updated contact
                    contactFound = true;
                } else
                    writer.write(currentLine + System.lineSeparator()); // Write the original line
            }
        } catch (IOException e) {
            System.out.println("Error updating contact: " + e.getMessage());
            return;
        }
        if (!contactFound) {
            System.out.println("Contact not found, please try again.");
            return;
        }
        if (oldFile.delete()) {
            if (!tempFile.renameTo(oldFile))
                System.out.println("Temp file cannot be renamed to the original file.");
            else
                System.out.println("Contact updated successfully.");
        }
        else
            System.out.println("Original file can't be deleted.");
    }

    public void deleteContacts() { // Deletes a specific contact.
        System.out.print("Enter a contact to delete: ");
        String deleteLine = scan.nextLine();
        File oldFile = new File("contacts.txt");
        File tempFile = new File("contacts_temp.txt");
        boolean contactFound = false;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(oldFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // If the current line matches the contact to delete, skip writing it to temp file
                if (currentLine.trim().equals(deleteLine.trim())) {
                    contactFound = true;
                    continue;
                }
                writer.write(currentLine + System.lineSeparator());
            }
        } catch (IOException e) {System.out.println("Could not delete contact, please try again.");}
        if (!contactFound) {
            System.out.println("Contact not found, please try again.");
            return;
        }
        if (oldFile.delete()) {
            if (!tempFile.renameTo(oldFile))
                System.out.println("Temp file cannot be renamed to the original file.");
            else
                System.out.println("Contact deleted successfully.");
        } else
            System.out.println("Original file can't be deleted.");
    }
}
