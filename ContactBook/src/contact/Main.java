
package contact;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ContactBook cb = new ContactBook();

        cb.loadContacts();

        int choice = 0;

        do {

            System.out.println("\n===== CONTACT BOOK =====");
            System.out.println("Press 1 for Add Contact");
            System.out.println("Press 2 for Search Contact");
            System.out.println("Press 3 for Delete Contact");
            System.out.println("Press 4 for Display All Contacts");
            System.out.println("Press 5 for Save Contact");
            System.out.println("Press 6 for Exit");

            System.out.println("Enter the choice:");

            try {

                choice = scan.nextInt();

                switch(choice) {

                    case 1 -> {
                        System.out.println("Enter Contact ID:");
                        int id = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Enter the name:");
                        String name = scan.nextLine();

                        System.out.println("Enter the Mobile:");
                        String mobile = scan.nextLine();

                        System.out.println("Enter the email:");
                        String email = scan.nextLine();

                        Contact c = new Contact(id, name, mobile, email);

                        cb.addContact(c);
                    }

                    case 2 -> {
                        System.out.println("Enter Contact ID:");
                        int id = scan.nextInt();

                        cb.searchContact(id);
                    }

                    case 3 -> {
                        System.out.println("Enter Contact ID:");
                        int id = scan.nextInt();

                        cb.deleteContact(id);
                    }

                    case 4 -> cb.displayAllContacts();

                    case 5 -> cb.saveContacts();

                    case 6 -> System.out.println("Thank you! Exiting Contact Book.");

                    default -> System.out.println("Invalid Choice!");
                }

            } catch(InputMismatchException e) {

                System.out.println("Please enter numbers only!");
                scan.nextLine();
                choice=0;
            }

        } while(choice != 6);

        scan.close();
    }
}
