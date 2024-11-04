import java.util.*;
import java.io.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ContactSystem contact = new ContactSystem();

    public static void main (String[] args) throws IOException {
        boolean condition = true;
        while (condition) {
            try {
                System.out.println("\n--CONTACT MANAGEMENT SYSTEM--");
                System.out.print("[1] Add Contact\n[2] View Contacts\n[3] Update Contact\n[4] Delete Contact\n[5] Exit\nChoose an Option: ");
                int option = scan.nextInt();
                switch (option) {
                    case 1:
                        contact.addContacts();
                        break;
                    case 2:
                        contact.viewContacts();
                        break;
                    case 3:
                        contact.updateContacts();
                        break;
                    case 4:
                        contact.deleteContacts();
                        break;
                    case 5:
                        condition = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("There was an error, Please try again.");
                }
            } catch (Exception e) {
                System.out.println("There was an error, please try again.");
                scan.nextLine();
            }
        }
    }
}
