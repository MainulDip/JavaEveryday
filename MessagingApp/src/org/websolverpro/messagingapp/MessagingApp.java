package org.websolverpro.messagingapp;

import java.util.Scanner;

/**
 * Simulate your phone's contacts and messages applications
 *
 * Greet the user
 * show 3 options: 1. Manage Contacts 2. Messages 3. Quit
 * when selecting 1 ==> show options
 *  1. Show all contacts
 *  2. Add a new contact
 *  3. Search for a contact
 *  4. Delete a contact
 *  5. Go back to the previous menu
 *
 * when selecting 2 ==> show options
 *  1. See the list of all messages
 *  2. Send a new message
 *  3. Go back to the previous menu
 *
 * when selection 3 ==> Quit the application
 */

public class MessagingApp {

    public static Scanner scanner;

    public static void main(String[] args) {

        boolean exitApp = false;

        while (!exitApp) {

            System.out.println("Good to see you \nPlease Select and Enter the Number \n 1. Manage Contacts 2. Messages 3. Quit\n");

            scanner = new Scanner(System.in);

            int firstFace = scanner.nextInt();

            switch (firstFace){
                case 1 :
                    System.out.println("You have chosen 1, now select newt option please");
                    manageContacts();
                    break;

                case 2 :
                    System.out.println("You have chosen 2, now select newt option please");
                    manageMessage();
                    break;

                default:
                    System.out.println("You have chosen to quit the application");
                    exitApp = true;
                    break;
            }

        }
    }

    public static void manageContacts() {

        boolean backMenu = false;

        while(!backMenu) {
            System.out.println("\n1. Show all contacts\n" +
                    "2. Add a new contact\n" +
                    "3. Search for a contact\n" +
                    "4. Delete a contact\n" +
                    "5. Go back to the previous menu\n");

            int contactInfoSelect = scanner.nextInt();

            switch (contactInfoSelect) {
                case 1 :
                    System.out.println("Show All Contacts");
                    ContactList.getContactList();
                    break;
                case 2 :
                    System.out.println("Add a new contact");
                    addContact();
                    break;
                case 3 :
                    System.out.println("Search For a contact");
                    ContactList.searchContact("Contact three");
                    break;
                case 4:
                    System.out.println("Delete a contact");
                    ContactList.deleteContact("Contact three");
                    break;
                default:
                    System.out.println("Go back to the previous menu");
                    backMenu = true;
                    break;
            }
        }


    }

    public static void manageMessage() {

        boolean backMenu = false;

        while(!backMenu) {
            System.out.println("\n1. See the list of all messages\n" +
                    "2. Send a new message\n" +
                    "3. Go back to the previous menu\n");

            int messageOptionSelect = scanner.nextInt();

            switch (messageOptionSelect) {
                case 1 :
                    System.out.println("Show All Messages");
                    Messages.getMessageList();
                    break;
                case 2 :
                    System.out.println("Send a new message");
                    sendMessage();
                    break;
                default:
                    System.out.println("Go back to the previous menu");
                    backMenu = true;
                    break;
            }
        }
    }

    public static void sendMessage() {
        System.out.println("Please Insert Message id");
        int id = scanner.nextInt();
        System.out.println("Please Insert Message recipient id");
        int receiver_id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please Insert Message body");
        String message_body = scanner.nextLine();
        System.out.println(message_body);

        Messages.addMessage(new Message(id, 4, receiver_id, message_body));
    }

    public static void addContact() {
        System.out.println("Please Insert Contact id");
        String id = scanner.next();
        System.out.println("Please Insert Contact Number");
        String number = scanner.next();
        scanner.nextLine();
        System.out.println("Please Insert Contact Name");
        String name = scanner.nextLine();
        System.out.println("id value is : " + id);

        if (id.equals("") || number.equals("") || name.equals("")) {
            addContact();
        } else {
            ContactList.addContact(new Contact(Integer.parseInt(id), name, Integer.parseInt(number)));
        }
    }
}
